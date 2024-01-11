package com.example.tramthuphikhongdung;

import java.io.PrintWriter;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import com.example.tramthuphikhongdung.entity.QuaTram;
import com.example.tramthuphikhongdung.entity.User;
import com.example.tramthuphikhongdung.service.MailService;
import com.example.tramthuphikhongdung.service.QuaTramService;
import com.example.tramthuphikhongdung.service.UserService;
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

@SpringBootApplication
public class TramThuPhiKhongDungApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	@Autowired
	private QuaTramService quaTramService;
	@Autowired 
	private MailService mailService;
	public static void main(String[] args) {
		SpringApplication.run(TramThuPhiKhongDungApplication.class, args);
	}
	
	// Tạo 1 luồng chạy song song với web
	@Override
	public void run(String... args) throws Exception {
		// lấy tất cả các port đang ở
		SerialPort[] serialPorts = SerialPort.getCommPorts();

		if (serialPorts.length == 0) {
			System.out.println("Không tìm thấy cổng serial.");
			//Lặp cho đến khi tìm thấy cổng kết nối
			while ((serialPorts = SerialPort.getCommPorts()).length == 0) {

			}
		
		}

		// Chọn cổng serial (ở đây sẽ chọn cổng đầu tiên)
		SerialPort serialPort = serialPorts[0];

		// Mở cổng serial
		if (serialPort.openPort()) {
			System.out.println("Đã mở cổng serial: " + serialPort.getSystemPortName());

			// Thiết lập baurate (tốc độ truyền)
			serialPort.setBaudRate(9600);

			// Đọc dữ liệu từ cổng serial nếu có thông tin được gửi đến
			serialPort.addDataListener(new SerialPortDataListener() {
				@Override
				public int getListeningEvents() {
					return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
				}

				@Override
				public void serialEvent(SerialPortEvent event) {
					if (event.getEventType() == SerialPort.LISTENING_EVENT_DATA_AVAILABLE) {
						Scanner sc = new Scanner(serialPort.getInputStream());
						PrintWriter pw = new PrintWriter(serialPort.getOutputStream());
						String rfid = "";
						//đọc thẻ dữ liệu được gửi tới từ arduino và xử lý dữ liệu
						while (sc.hasNextLine()) {
							rfid = sc.nextLine();
							System.out.println(rfid);
							if (rfid.equals("out")) {
								messagingTemplate.convertAndSend("/topic/data", new User());
							} else {
								// tìm kiếm user theo mã rfid
								User user = userService.getUserByRfid(rfid);	
								//Kiểm tra khi người dùng tồn tại
								if (user != null) {
									// Kiểm tra màu biển của người dùng
									if(user.getMaubien().equals("Màu trắng")) {
										// Kiểm tra số dư của người dùng nếu đủ tiền thì xử lý gửi lên web, mail, lưu database, nếu không đủ thì trả về arduino là false
										if(user.getSodu() >=25000) {
											user.setSodu(user.getSodu()-25000);
											pw.write(user.getBienso());
											pw.flush();
											//Cập nhập lại thông tin người dùng
											userService.updateUser(user);
											QuaTram quaTram = new QuaTram();										
											long millis = System.currentTimeMillis();
											java.sql.Date dateNow = new java.sql.Date(millis);	
											quaTram.setThoigian(dateNow);
											quaTram.setUser(user);
											// Lưu thông tin qua trạm vào database
											quaTramService.save(quaTram);								
											// Sử dựng websocket để gửi thông tin lên trình duyệt
											messagingTemplate.convertAndSend("/topic/data", user);
											// Gửi email
											mailService.sendEmail(user.getEmail(), "Trạm thu phí không dừng", "Bạn đã đi qua trạm vào lức "+ dateNow);

										}else {
											//gửi false về arduino
											pw.write("false");
											pw.flush();
										}

									}else if(user.getMaubien().equals("Màu vàng")) {
										if(user.getSodu()>=30000) {
											pw.write(user.getBienso());
											pw.flush();
											user.setSodu(user.getSodu()-30000);
											userService.updateUser(user);
											QuaTram quaTram = new QuaTram();										
											long millis = System.currentTimeMillis();
											java.sql.Date dateNow = new java.sql.Date(millis);	
											quaTram.setThoigian(dateNow);
											quaTram.setUser(user);
											quaTramService.save(quaTram);
											messagingTemplate.convertAndSend("/topic/data", user);
											mailService.sendEmail(user.getEmail(), "Trạm thu phí không dừng", "Bạn đã đi qua trạm vào lức "+ dateNow);

										}else {
											pw.write("false");
											pw.flush();
										}
									}else {
										pw.write(user.getBienso());
										pw.flush();
										user.setSodu(user.getSodu()-0);
										userService.updateUser(user);
										QuaTram quaTram = new QuaTram();										
										long millis = System.currentTimeMillis();
										java.sql.Date dateNow = new java.sql.Date(millis);	
										quaTram.setThoigian(dateNow);
										quaTram.setUser(user);
										quaTramService.save(quaTram);
										messagingTemplate.convertAndSend("/topic/data", user);
										mailService.sendEmail(user.getEmail(), "Trạm thu phí không dừng", "Bạn đã đi qua trạm vào lức "+ dateNow);
										

									}										

								} else {
									pw.write("false");
									pw.flush();
								}
							}
						}
					}
				}
			});
		} else {
			System.out.println("Không thể mở cổng serial: " + serialPort.getSystemPortName());
		}
	}
}

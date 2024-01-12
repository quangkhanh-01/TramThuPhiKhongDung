package restman25.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restman25.model.MonAn424;

public class MonAnDAO424 extends DAO424 {
	public MonAnDAO424() {
		super();
	}
	public List<MonAn424> timMonAn(String tukhoa){
		List<MonAn424> listMonAn= new ArrayList<>();
		String sql = "select * from tblmonan424 where id like ? or ten like ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+tukhoa+"%");
			ps.setString(2, "%"+tukhoa+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				MonAn424 monAn = new MonAn424();
				monAn.setId(rs.getInt("id"));
				monAn.setTen(rs.getString("ten"));
				monAn.setGiaTien(rs.getFloat("giaTien"));
				monAn.setMoTa(rs.getString("moTa"));
				listMonAn.add(monAn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(listMonAn.size()==0) {
			return null;
		}else {
			return listMonAn;
		}
	}
	
	public MonAn424 getThongTinMonAn(int idMonAn) {
		MonAn424 monAn = null;
		String sql = "select * from tblmonan424 where id=?";
		try {
			monAn = new MonAn424();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idMonAn);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				monAn.setId(rs.getInt("id"));
				monAn.setTen(rs.getString("ten"));
				monAn.setGiaTien(rs.getFloat("giaTien"));
				monAn.setMoTa(rs.getString("moTa"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return monAn;
	}
}

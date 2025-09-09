package modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.javabean.Region;

public class RegionDaoImplMy8Jdbc extends AbsGenericoDaoImpl implements RegionDao{
	
	public RegionDaoImplMy8Jdbc() {
		super();
	}

	@Override
	public List<Region> findAll() {
		sql = "select * from regions";
		List<Region> aux = new ArrayList<Region>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Region region = new Region();
				
				region.setRegionId(rs.getInt("region_id"));
				region.setRegionName(rs.getString("region_name"));
				
				aux.add(region);
				
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aux;
	}

	@Override
	public Region findById(int regionId) {
		sql = "select * from regions where region_id = ?";
		Region region = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, regionId);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				region = new Region();
				
				region.setRegionId(rs.getInt("region_id"));
				region.setRegionName(rs.getString("region_name"));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return region;
	}

	@Override
	public int insertOne(Region region) {
		sql = "insert into regions (region_id, region_name) values (?,?)";
		filas=0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, region.getRegionId());
			ps.setString(2, region.getRegionName());
			
			filas = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			filas = 0;
		}
		
		return filas;
	}

	@Override
	public int updateOne(Region region) {
		sql = "update regions set region_name = ? where region_id = ?";
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, region.getRegionName());
			ps.setInt(2, region.getRegionId());
			filas = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return filas;
		
		
	}

	@Override
	public int deleteOne(int regionId) {
		sql = "delete from regions where region_id = ?";
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, regionId);
			filas = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
			filas = -1;
		}
		return filas;
	}

}

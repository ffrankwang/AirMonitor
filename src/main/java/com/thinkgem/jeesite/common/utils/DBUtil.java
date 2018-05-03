package com.thinkgem.jeesite.common.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.thinkgem.jeesite.modules.air.entity.TbTempHum;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

public class DBUtil {
	private static Connection conn=getConnection();

	public static Connection getConnection() {
		String url = "jdbc:MySQL://127.0.0.1:3306/air_monitor";
		String driverClassName = "com.mysql.jdbc.Driver";
		String username = "root";
		String password = "root";
		DbUtils.loadDriver(driverClassName);
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void insertCO2(String co2) {
		QueryRunner qr = new QueryRunner();
		String sql = "INSERT INTO tb_co2(id,co2,create_by,create_date,update_by,update_date,del_flag) VALUES(?,?,?,?,?,?,?)";
		try {
			qr.update(conn, sql, IdGen.uuid(), co2, "1", new Date(), "1", new Date(), "1");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void insertTempHum(String temp, String hum) {
		QueryRunner qr = new QueryRunner();
		String sql = "INSERT INTO tb_temp_hum(id,temp,hum,create_by,create_date,update_by,update_date,del_flag) VALUES(?,?,?,?,?,?,?,?)";
		try {
			qr.update(conn, sql, IdGen.uuid(), temp, hum, "1", new Date(), "1", new Date(), "1");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertPM2_5(String pm2_5) {
		QueryRunner qr = new QueryRunner();
		String sql = "INSERT INTO tb_pm2_5(id,pm2_5,create_by,create_date,update_by,update_date,del_flag) VALUES(?,?,?,?,?,?,?)";
		try {
			qr.update(conn, sql, IdGen.uuid(), pm2_5, "1", new Date(), "1", new Date(), "1");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static TbTempHum queryTempHum() {
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM tb_temp_hum ORDER BY create_date DESC LIMIT 1";
		TbTempHum lastTempHum = null;
		try {
			lastTempHum = qr.query(conn,sql, new BeanHandler<TbTempHum>(TbTempHum.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lastTempHum;
	}

	public static List<Map<String, Object>> queryDatas() {
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT a.id,a.title,b.data1,b.data2 FROM cdb_brand_type_5 a,cdb_brand_type_6 b WHERE a.specialid = b.specialid limit 100000";
		try {

			List<Map<String, Object>> query = qr.query(conn, sql, new MapListHandler());
			return query;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;


	}

}

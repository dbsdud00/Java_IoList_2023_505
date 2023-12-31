package com.callor.iolist.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.callor.iolist.config.DBContract;
import com.callor.iolist.models.IolistDto;

/*
 *  1. 판매 내역 등록(장바구니 담기)
 *  2. 장바구니 전체 리스트
 *  3. 기간별 거래 리스트
 *  4. 고객별 리스트
 *  5. 상품별 리스트\
 *  6. 고객 + 거래 기간별 리스트 
 */
public interface IolistDao {

	// 전체 리스트
	@Select("SELECT * FROM " + DBContract.TABLE.IOSLIST + " ORDER BY io_date, io_time")
	public List<IolistDto> selectAll();

	// 기간별 리스트
	@Select("SELECT * FROM " + DBContract.TABLE.IOSLIST + " WHERE io_date BETWEEN #{sDate} AND #{eDate} "
			+ " ORDER BY io_date, io_time")
	public List<IolistDto> selectBetweenDate(String sDate, String eDate);

	// 고객별 리스트
	@Select("SELECT * FROM " + DBContract.TABLE.IOSLIST + " WHERE io_buid = #{buId} " + " ORDER BY io_date, io_time")
	public List<IolistDto> selectByBuyer(String buId);

	// 상품별 리스트
	@Select("SELECT * FROM " + DBContract.TABLE.IOSLIST + " WHERE io_pCode = #{pCode} " + " ORDER BY io_date, io_time")
	public List<IolistDto> selectByProduct(String pCode);

	// 고객 + 기간벌 리스트
	@Select("SELECT * FROM " + DBContract.TABLE.IOSLIST + " WHERE io_buid = #{buId} "
			+ " AND io_date BETWEEN #{sDate} AND #{eDate} " + " ORDER BY io_date, io_time")
	public List<IolistDto> selectByBuyerBetweenDate(String buId, String sDate, String eDate);

	// 상품 + 기간별 리스트
	@Select("SELECT * FROM " + DBContract.TABLE.IOSLIST + " WHERE io_pCode = #{pCode} "
			+ " AND io_date BETWEEN #{sDate} AND #{eDate} " + " ORDER BY io_date, io_time")
	public List<IolistDto> selectByProductBetweenDate(String pCode, String sDate, String eDate);

	@Insert("INSERT INTO " + DBContract.TABLE.IOSLIST 
			+ " (ioDate, ioTime, ioBuId,"
			+ " ioPCode, ioQuan, ioPrice, ioTotal ) "
			+ " VALUES(#{ioDate}, #{ioTime}, #{ioBuId},"
			+ " #{ioPCode}, #{ioQuan}, #{ioPrice}, #{ioTotal} ) ")
	public int insert(IolistDto iolistDto);
	
}

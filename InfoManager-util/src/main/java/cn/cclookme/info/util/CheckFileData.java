package cn.cclookme.info.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.cclookme.info.model.schedule.BasicsCourseSchedule;
import cn.cclookme.info.model.schedule.BasicsCourseScheduleExcel;

public class CheckFileData {
	private static final Logger log=Logger.getLogger(CheckFileData.class);
	
	public List<BasicsCourseScheduleExcel> getCheckFileData(File file){
			Workbook wb = null;
			Sheet sheet=null;
			Row row=null;
			InputStream is=null;
			try {
				is=new FileInputStream(file);
				if (!is.markSupported()) {
					is = new PushbackInputStream(is, 8);
				}
				// 创建工作薄,读取2003Excel和2007Excel
				if (POIFSFileSystem.hasPOIFSHeader(is)) {
					wb = new HSSFWorkbook(is);
				} else if (POIXMLDocument.hasOOXMLHeader(is)) {
					wb = new XSSFWorkbook(OPCPackage.open(is));
				}
			} catch (Exception e) {
				log.error("读取Excel文件失败", e);
			} finally {
				if(is != null){
					try {
						is.close();
					} catch (IOException e) {
						log.error("关闭流出错!", e);
					}
				}
			}
			
			List<BasicsCourseScheduleExcel>  list=new ArrayList<BasicsCourseScheduleExcel>();
			sheet = wb.getSheetAt(1);
			// 得到总行数
			int rowNum = sheet.getLastRowNum();
			row = sheet.getRow(0);
			
			int colNum = row.getPhysicalNumberOfCells();
			// 正文内容应该从第二行开始,第一行为表头的标题
			for (int i = 1; i <= rowNum; i++) {
				row = sheet.getRow(i);
				int j = 0;
				BasicsCourseScheduleExcel basicsCourseSchedule=new BasicsCourseScheduleExcel();
				while (j < colNum) {
					String str = getCellFormatValue(row.getCell((short) j)).trim();
					switch(j){
						case 0:
							basicsCourseSchedule.setCourseCode(str);
							break;
						case 1:
							basicsCourseSchedule.setSpecialty(str);
							break;
						case 2:
							basicsCourseSchedule.setCourseStartTime(str.replace(".", "-"));
							break;
						case 3:
							basicsCourseSchedule.setCourseEndTime(str.replace(".", "-"));
							break;
						case 4:
							basicsCourseSchedule.setCourseTeacher(str);
							break;
						case 5:
							basicsCourseSchedule.setExaminationTime(str.replace(".", "-"));
							break;
						case 6:
							basicsCourseSchedule.setSchooltime(str.replace(".", "-"));
							break;  	
						case 7:
							basicsCourseSchedule.setYearin(str);
							break;
					}
					j++;
				}
				list.add(basicsCourseSchedule);
			}
		return list;
	}
    public String getStringCellValue(Cell cell) {
        String strCell = "";
        switch (cell.getCellType()) {
        case HSSFCell.CELL_TYPE_STRING:
            strCell = cell.getStringCellValue();
            break;
        case HSSFCell.CELL_TYPE_NUMERIC:
            strCell = String.valueOf(cell.getNumericCellValue());
            break;
        case HSSFCell.CELL_TYPE_BOOLEAN:
            strCell = String.valueOf(cell.getBooleanCellValue());
            break;
        case HSSFCell.CELL_TYPE_BLANK:
            strCell = "";
            break;
        default:
            strCell = "";
            break;
        }
        if (strCell.equals("") || strCell == null) {
            return "";
        }
        if (cell == null) {
            return "";
        }
        return strCell;
    }

   
    public  String getDateCellValue(HSSFCell cell) {
        String result = "";
        try {
            int cellType = cell.getCellType();
            if (cellType == HSSFCell.CELL_TYPE_NUMERIC) {
                Date date = cell.getDateCellValue();
                result = (date.getYear() + 1900) + "-" + (date.getMonth() + 1)
                        + "-" + date.getDate();
            } else if (cellType == HSSFCell.CELL_TYPE_STRING) {
                String date = getStringCellValue(cell);
                result = date.replaceAll("[年月]", "-").replace("日", "").trim();
            } else if (cellType == HSSFCell.CELL_TYPE_BLANK) {
                result = "";
            }
        } catch (Exception e) {
            System.out.println("日期格式不正确!");
            e.printStackTrace();
        }
        return result;
    }
    public String getCellFormatValue(Cell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
            // 如果当前Cell的Type为NUMERIC
            case HSSFCell.CELL_TYPE_NUMERIC:
            case HSSFCell.CELL_TYPE_FORMULA: {
                // 判断当前的cell是否为Date
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    // 如果是Date类型则，转化为Data格式
                    
                    //方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
                    //cellvalue = cell.getDateCellValue().toLocaleString();
                    
                    //方法2：这样子的data格式是不带带时分秒的：2011-10-12
                    Date date = cell.getDateCellValue();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    cellvalue = sdf.format(date);
                    
                }
                // 如果是纯数字
                else {
                    // 取得当前Cell的数值
                    cellvalue = String.valueOf((int)cell.getNumericCellValue());
                }
                break;
            }
            // 如果当前Cell的Type为STRIN
            case HSSFCell.CELL_TYPE_STRING:
                // 取得当前的Cell字符串
                cellvalue = cell.getRichStringCellValue().getString();
                break;
            // 默认的Cell值
            default:
                cellvalue = " ";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;

    }
}

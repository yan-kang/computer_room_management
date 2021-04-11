package com.kang.computer_room_management.common;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    String logPath="E:\\log\\log.txt";
    public void printLog(Exception exception){
        try{
            logDate(getTrace(exception));
        }catch (FileNotFoundException e){
            catchFileNotFound(e);
        } catch (IOException e) {
            printLog(e);
        }
    }
    public void printLog(String string){
        try{
            logDate(string);
        }catch (FileNotFoundException e){
            catchFileNotFound(e);
        } catch (IOException e) {
            printLog(e);
        }
    }

    private void logDate(String string) throws IOException {
        OutputStream file=new FileOutputStream(logPath,true);
        OutputStreamWriter writer=new OutputStreamWriter(file,"utf8");
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = format.format(date);
        writer.write(dateString);
        writer.append("\r\n");
        writer.write(string);
        writer.append("\r\n");
        writer.close();
        file.close();
    }

    public static String getTrace(Throwable t) {
        StringWriter stringWriter= new StringWriter();
        PrintWriter writer= new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        StringBuffer buffer= stringWriter.getBuffer();
        return buffer.toString();
    }
    void catchFileNotFound(FileNotFoundException e){
        File file=new File(logPath);
        File file1=new File("E:\\log");
        if(!file.exists())
            try {
                if(file1.mkdir()) printLog("创建路径成功!");
                if(file.createNewFile()) printLog("新建文件成功!");;
            }catch (IOException io){
                printLog(io);
            }
    }

    /**
     * @return 输入数字及窗口大小，返回窗口id
     */
    public int returnValueBy(int number,int window){
        if(number%window==0){
            return number/window;
        }
        else{
            return number/window+1;
        }
    }
    public String getDescription(int status){
        String description;
        switch (status){
            case 3:
                description="机房空闲";
                break;
            case 2:
                description="机房有空闲机位";
                break;
            case 1:
                description="机房已被预约";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + status);
        }
        return description;
    }
}

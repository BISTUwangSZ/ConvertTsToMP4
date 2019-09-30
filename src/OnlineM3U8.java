import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class OnlineM3U8 {

    private static String fileNameWithVersion="";

    /**
     * 下载TS文件
     * @param path      M3u8文件目录
     * @return
     */
    public String downloadM3U8FromLine(String path, String targetPath,String fileName){
        String filePath="";
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            //设置超时间为3秒
            conn.setConnectTimeout(3*1000);
            //防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            //得到输入流
            InputStream inputStream = conn.getInputStream();
            //获取自己数组
            byte[] getData = readInputStream(inputStream);
            //文件保存位置
            File saveDir = new File(targetPath);
            if(!saveDir.exists()){
                saveDir.mkdirs();
            }
            //文件
            File file = new File(saveDir + File.separator + fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(getData);
            if(fos!=null){
                fos.close();
            }
            if(inputStream!=null){
                inputStream.close();
            }
            System.out.println("info:"+"m3u8 file download success");
            filePath = targetPath + File.separator + fileName;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }

    /**
     * 读取文件流
     */
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }


    /**
     * 拼接TS地址
     */
    public List<String> getTSUrlList(String filePath, String tsPrePath){
        List<String> tsUrlList = new ArrayList<>();
        String tempTs = "";
        //读取m3u8文件
        try {
            String len = "";
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis,"GBK"));
            while ( (len = reader.readLine()) !=null ) {
                if (len.contains(".ts")) {
                    tempTs = tsPrePath+len;
                    tsUrlList.add(tempTs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //拼接每一个ts的完整地址
        return tsUrlList;
    }


    /**
     *TS转换为MP4
     */
    public void downloadTs(List<String> tsUrls,String tsPath, String tsFileName){
        try {
            //文件保存位置
            File saveDir = new File(tsPath);
            if(!saveDir.exists()){
                saveDir.mkdirs();
            }
            //文件
            File file = new File(saveDir + File.separator + tsFileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            InputStream inputStream = null;
            URL url = null;
            System.out.println("downloading files ~~~~~~");
            for (String tsUrl : tsUrls) {
                url = new URL(tsUrl);
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                //设置超时间为3秒
                conn.setConnectTimeout(3*1000);
                //防止屏蔽程序抓取而返回403错误
                conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
                //得到输入流
                inputStream = conn.getInputStream();
                //获取自己数组
                byte[] getData = readInputStream(inputStream);
                fos.write(getData);
            }
            System.out.println("convert to mp4 finished");
            if(fos!=null){
                fos.close();
            }
            if(inputStream!=null){
                inputStream.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据URL获取文件名
     * @param url   请求地址
     */
    public String getFileName(String url){
        String res = "";
        String yuming = "";//存储出http和https意外的部分
        if (url.contains("http") || url.contains("https")) {
            String[] withOutHttps = url.split("//");
            yuming = withOutHttps[1];
        } else {
            yuming = url;
        }
        //存储按/区分的每一部分，最后一部分为文件名
        String[] fileNameArr = yuming.split("/");
        String tempFileName = fileNameArr[fileNameArr.length-1];//腾讯的最后一部分是 xxx.m3u8?version=4
        if (tempFileName.contains(".m3u8")) {
            String fileName = tempFileName.split(".m3u8")[0]+".m3u8";
            res = fileName;
        } else {
            return "获取名称错误";
        }
        fileNameWithVersion = tempFileName; //获取前缀的时候有用
        return res;
    }

    /**
     * 根据请求四只获取请求的前缀
     * @param url           请求地址
     */
    public String getTsPrePath(String url){
        String temp = url.replace(fileNameWithVersion,"");
        return temp;
    }


/*    public static void main(String[] args){
        OnlineM3U8 m3U8 = new OnlineM3U8();
        String dir = "E:\\onlineM3U8";
        //下载m3u8文件
        String m3u8Path = "https://apd-ed0dc164b117170f7f9313287bb28156.v.smtcdns.com/moviets.tc.qq.com/AJ_6njadjxAn-8llbTB8RWsM3E4Pu31_sqBUa_VTnd1w/uwMROfz2r5xgoaQXGdGnC2df645GziNP4fCTXzcc9dfItw5M/OuQfOV85Z8j07ppnV5zt1iLrYZP0EFsQNSisbAjTNrwFfG7AD5KdC8_0uxsRytvHAtxbOrLN6ioQY8N7m6pNB-mYAhA3ECs00l2rpf3B4w_OXChgR8pp5CDR6G6j0FL5TSwnxd7jxQFYV0i28nHowVB3ohOcYjPs8vqhrJkIeMc/w0031s4gikk.321002.ts.m3u8?ver=4";
        String fileName = m3U8.getFileName(m3u8Path);
        String filePath = m3U8.downloadM3U8FromLine(m3u8Path,dir+"\\m3u8",fileName);
        //读取解析m3u8文件，拼接url
        String tsPrePath = m3U8.getTsPrePath(m3u8Path);
        List<String> tsUrls = m3U8.getTSUrlList(filePath,tsPrePath);
        //下载TS文件
        String tsPath = dir+"\\ts";
        String tsFileName = "陈情令第一集.mp4";
        m3U8.downloadTs(tsUrls,tsPath,tsFileName);
    }*/
}

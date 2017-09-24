package com.demo.java.file.newfile;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.配置svn下载目录：svnCommitPath。
 * 2.配置项目所在本地目录：projectPath。
 * 3.增加提交文件目录：getSourceFilePath_20170623。
 * 4.定义提交文件夹名称：svnCommitFileName。
 * 5.启动。
 * Created by maosheng on 2017/6/22.
 */
public class UnisTest {
    private static String svnCommitPath = "D:\\technology\\datasource\\svncommitswap160\\";
    private static String projectPath = "D:\\technology\\datasource\\unis";

    public static void main (String[] org0){
        String[] sourceFilePath = UnisTest.getSourceFilePath_20170623();
        UnisTest.copyFile("20170623_wms",sourceFilePath);

    }

    public static String[] getSourceFilePath_20170623(){
        String[] sourceFilePath = {
            "D:\\technology\\datasource\\unis\\ba\\ba\\src\\main\\java\\com\\thunis\\ba\\controller\\json\\tram\\tramManage\\TramDefaultinterestsDetailJsonController.java",
            "D:\\technology\\datasource\\unis\\ba\\ba\\src\\main\\java\\com\\thunis\\ba\\bs\\impl\\tram\\tramManage\\TramDefaultinterestsDetailServiceImpl.java",
            "D:\\technology\\datasource\\unis\\ba\\ba\\src\\main\\resources\\mappings\\ba\\tram\\tramManage\\TramDefaultinterestsApplyMapper.xml",
            "D:\\technology\\datasource\\unis\\ba\\ba\\src\\main\\java\\com\\thunis\\ba\\bs\\inf\\tram\\tramManage\\TramDefaultinterestsDetailService.java",
            "D:\\technology\\datasource\\unis\\ba\\ba\\src\\main\\java\\com\\thunis\\ba\\model\\tram\\tramManage\\TramDefaultinterestsApplyVo.java",
            "D:\\technology\\datasource\\unis\\ba\\ba\\src\\main\\webapp\\WEB-INF\\views\\ba\\tram\\tramManage\\tramDefaultinterestsDetail.jsp",
        };
        return sourceFilePath;
    }

    /**
     *
     * @param svnCommitFileName
     * @param sourceFilePaths
     * @return
     *      Map<sourceFilePath,targetFilePath>
     */
    public static Map<String,String> targetFilePath(String svnCommitFileName,String[] sourceFilePaths){
        Map<String,String> map = new HashMap<>();
        for (String sourceFilePath : sourceFilePaths) {
            int sL = sourceFilePath.indexOf(projectPath) + projectPath.length();
            String targetFilePath = svnCommitPath + svnCommitFileName+ sourceFilePath.substring(sL);
            System.out.println(targetFilePath);
            map.put(sourceFilePath,targetFilePath);
        }
        return map;
    }

    public static void copyFile(String svnCommitFileName,String[] sourceFilePath){
        Map<String,String> targetFilePath = targetFilePath(svnCommitFileName,sourceFilePath);
        int sucCount = 0;
        int failCount = 0;
        for (Map.Entry<String, String> entry : targetFilePath.entrySet()) {
            boolean b = CopyFileUtil.copyFile(entry.getKey(),entry.getValue(),true);
            if(b)
                sucCount ++ ;
            else
                failCount ++ ;
        }
        System.out.println("创建目录成功成功成功次数："+sucCount);
        System.out.println("创建目录失败失败失败次数："+failCount);

    }

}

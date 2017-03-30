package com.demo.java.jdbc;

import com.demo.java.date.DateUtil;
import com.demo.java.math.RandomUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by mesen on 2017/3/29.
 */
public class InsertTest {
    static String[] name = new String[] {
            "赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "楮", "卫", "蒋", "沈", "韩", "杨",
            "朱", "秦", "尤", "许", "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜",
            "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎",
            "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍", "史", "唐",
            "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷", "罗", "毕", "郝", "邬", "安", "常",
            "乐", "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄",
            "和", "穆", "萧", "尹", "姚", "邵", "湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧",
            "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒", "屈", "项", "祝", "董", "梁",
            "杜", "阮", "蓝", "闽", "席", "季", "麻", "强", "贾", "路", "娄", "危", "江", "童", "颜", "郭",
            "梅", "盛", "林", "刁", "锺", "徐", "丘", "骆", "高", "夏", "蔡", "田", "樊", "胡", "凌", "霍",
            "虞", "万", "支", "柯", "昝", "管", "卢", "莫", "经", "房", "裘", "缪", "干", "解", "应", "宗",
            "丁", "宣", "贲", "邓", "郁", "单", "杭", "洪", "包", "诸", "左", "石", "崔", "吉", "钮", "龚",
            "程", "嵇", "邢", "滑", "裴", "陆", "荣", "翁", "荀", "羊", "於", "惠", "甄", "麹", "家", "封",
            "芮", "羿", "储", "靳", "汲", "邴", "糜", "松", "井", "段", "富", "巫", "乌", "焦", "巴", "弓",
            "牧", "隗", "山", "谷", "车", "侯", "宓", "蓬", "全", "郗", "班", "仰", "秋", "仲", "伊", "宫",
            "宁", "仇", "栾", "暴", "甘", "斜", "厉", "戎", "祖", "武", "符", "刘", "景", "詹", "束", "龙",
            "叶", "幸", "司", "韶", "郜", "黎", "蓟", "薄", "印", "宿", "白", "怀", "蒲", "邰", "从", "鄂",
            "索", "咸", "籍", "赖", "卓", "蔺", "屠", "蒙", "池", "乔", "阴", "郁", "胥", "能", "苍", "双",
            "闻", "莘", "党", "翟", "谭", "贡", "劳", "逄", "姬", "申", "扶", "堵", "冉", "宰", "郦", "雍",
            "郤", "璩", "桑", "桂", "濮", "牛", "寿", "通", "边", "扈", "燕", "冀", "郏", "浦", "尚", "农",
            "温", "别", "庄", "晏", "柴", "瞿", "阎", "充", "慕", "连", "茹", "习", "宦", "艾", "鱼", "容",
            "向", "古", "易", "慎", "戈", "廖", "庾", "终", "暨", "居", "衡", "步", "都", "耿", "满", "弘",
            "匡", "国", "文", "寇", "广", "禄", "阙", "东", "欧", "殳", "沃", "利", "蔚", "越", "夔", "隆",
            "师", "巩", "厍", "聂", "晁", "勾", "敖", "融", "冷", "訾", "辛", "阚", "那", "简", "饶", "空",
            "曾", "毋", "沙", "乜", "养", "鞠", "须", "丰", "巢", "关", "蒯", "相", "查", "后", "荆", "红",
            "游", "竺", "权", "逑", "盖", "益", "桓", "公", "仉", "督", "晋", "楚", "阎", "法", "汝", "鄢",
            "涂", "钦", "岳", "帅", "缑", "亢", "况", "后", "有", "琴", "归", "海", "墨", "哈", "谯", "笪",
            "年", "爱", "阳", "佟", "商", "牟", "佘", "佴", "伯", "赏"
    };

    static String[] sexStr = new String[]{"男","女"};

    static String[] prof = new String[]{"高级讲师","讲师","助教","特级教师","副教授","教授"};

    static String[] depart = new String[]{"理学","工学","农学","医学","哲学","经济学","法学","教育学","文学","历史","军事学","管理学","地理科学","生物科学","化学类","心理类","美术学","社会学"};

    static String[] address = new String[]{"北京市","天津市","上海市","重庆市","河北省","山西省","辽宁省","吉林省","黑龙江省","江苏省","浙江省","安徽省","福建省","江西省","山东省","河南省","湖北省","湖南省","广东省","海南省","四川省","贵州省","云南省","陕西省","甘肃省","青海省","台湾省","内蒙古自治区","广西壮族自治区","西藏自治区","宁夏回族自治区","新疆维吾尔自治区","香港特别行政区","澳门特别行政区"};

    static String[] school = new String[]{"清华大学","北京大学","中国人民大学","华南理工大学","中国农业大学","南开大学","天津大学","大连理工大学","东北大学","吉林大学","复旦大学","上海交通大学","同济大学","南京大学","东南大学","浙江大学","厦门大学","山东大学","中国海洋大学","武汉大学","华中科技大学","中南大学","湖南大学","中山大学","北京师范大学","重庆大学","四川大学","电子科技大学","西安交通大学","西北农林科技大学","兰州大学","北京航空航天大学","北京理工大学","中央民族大学","哈尔滨工业大学","中国科学技术大学","国防科学技术大学","西北工业大学"};

    public static void insert(Connection conn) {
        // 开始时间
        Long begin = new Date().getTime();

        // sql前缀
        String prefix = "INSERT INTO teacher (id,name,sex,age,address,prof,depart,school_name,school_address,create_time) VALUES ";
        try {
            // 保存sql后缀
            StringBuffer suffix ;

            // 设置事务为非自动提交
            conn.setAutoCommit(false);

            // 比起st，pst会更好些
            PreparedStatement pst = conn.prepareStatement("");

            // 外层循环，总提交事务次数
            for (int i = 1; i <= 100; i++) {
                suffix = new StringBuffer();
                Long p1 = new Date().getTime();

                for (int j = 1; j <= 100000; j++) {
                    suffix.append("('"+UUID.randomUUID().toString()+"','");
                    suffix.append(RandomUtil.genRandomS(name,2)+"','");
                    suffix.append(RandomUtil.genRandomS(sexStr,1)+"','");
                    suffix.append(RandomUtil.genRandomInt(20,50)+"','");
                    suffix.append(RandomUtil.genRandomS(address,1)+"','");
                    suffix.append(RandomUtil.genRandomS(prof,1)+"','");
                    suffix.append(RandomUtil.genRandomS(depart,1)+"','");
                    suffix.append(RandomUtil.genRandomS(school,1)+"','");
                    suffix.append(RandomUtil.genRandomS(address,1)+"','");
                    suffix.append(DateUtil.dateS()+"'),");

                }

                // 构建完整SQL
                String sql = prefix + suffix.substring(0, suffix.length() - 1);
                Long p2 = new Date().getTime();

                Long z1 = new Date().getTime();

                // 添加执行SQL
                pst.addBatch(sql);
                // 执行操作
                pst.executeBatch();

                // 提交事务
                conn.commit();

                Long z2 = new Date().getTime();

                System.out.println(i + "插入了10万条数据。" + "***提交事务用了" + (z2 - z1) / 1000 + " s" );
            }
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Long end = new Date().getTime();

        // 耗时
        System.out.println("1000万条数据插入花费时间 : " + (end - begin) / 1000 + " s");
        System.out.println("插入完成");
    }

    public static void main(String[] args) {
        insert(DBConUtil.getConnection());
    }
}

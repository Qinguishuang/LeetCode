package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 现在程序中有一组学生成绩数据（getScoreList()返回结果），每条数据为某个学生的某科成绩。
 * 学生成绩可能不是4科都有，可能有缺科。要求对这组数据进行数据转换和计算处理，转换成学生记录列表，
 * 每条记录里面有4科成绩和总成绩，并在此基础上计算全班的平均成绩。
 * 最后用控制台输出即可，要求表格按总成绩从高到低排序。计算平均成绩时，缺课也算人次，
 * 结果保留三位小数，输出格式如下。
 * 需要注意的是，最终完成代码的代码质量（逻辑是否清晰，变量/方法命名是否合理等），将作为考察标准的一部分
 * 姓名		数学		语文		英语		物理		总成绩
 * 张三		 		  65	   84	     89	      316
 * 李四		 89		  76				 76		  313
 * …
 * 平均成绩    83.5	 70.5	  78	    82.5	314.5
 */

public class ShowMeBug {
    public static void main(String[] args) {
        List<ScoreVo> scoreList = getScoreList();
        // TODO 请编写代码实现题目要求
        ShowMeBug showMeBug = new ShowMeBug(); // 用来产生StudentVo对象
        Map<String, StudentVo> studentVoMap = new HashMap<>(); // 以学生名字为key, 方便查找
        // 将所有的记录放入StudentVo中
        for (ScoreVo scoreVo : scoreList) {
            if (!studentVoMap.containsKey(scoreVo.studentName)) { // 第一次放入map的话，需要先创建一个StudentVo
                StudentVo studentVo = showMeBug.new StudentVo();
                studentVo.setName(scoreVo.studentName);
                studentVoMap.put(scoreVo.studentName, studentVo);
            }
            StudentVo studentVo = studentVoMap.get(scoreVo.studentName);
            switch (scoreVo.courseName) {
                case "数学": {
                    studentVo.setMathScore(scoreVo.score);
                    break;
                }
                case "语文": {
                    studentVo.setChineseScore(scoreVo.score);
                    break;
                }
                case "英语": {
                    studentVo.setEnglishScore(scoreVo.score);
                    break;
                }
                case "物理": {
                    studentVo.setPhysicalScore(scoreVo.score);
                    break;
                }
                default: {
                    System.out.println("课程名错误");
                    break;
                }
            }
        }
        // 计算个人中分, 同时计算总体总分
        double sumMath = 0;
        double sumChinese = 0;
        double sumEnglish = 0;
        double sumPhysical = 0;
        double sumScore = 0;
        for (Map.Entry<String, StudentVo> entry : studentVoMap.entrySet()) {
            double totalScore = 0;
            StudentVo studentVo = entry.getValue();

            sumChinese += studentVo.getChineseScore();
            sumMath += studentVo.getMathScore();
            sumEnglish += studentVo.getEnglishScore();
            sumPhysical += studentVo.getPhysicalScore();

            totalScore = studentVo.getChineseScore() + studentVo.getMathScore() +
                    studentVo.getEnglishScore() + studentVo.getPhysicalScore();

            studentVo.setTotalScore(totalScore);
        }
        sumScore = sumChinese + sumMath + sumEnglish + sumPhysical;
        // 排序
        List<StudentVo> studentVos = new ArrayList<>(studentVoMap.values());
        studentVos.sort(new Comparator<StudentVo>() {
            @Override
            public int compare(StudentVo o1, StudentVo o2) {
                return (int) (o2.getTotalScore() - o1.getTotalScore());
            }
        });

        // 格式化输出
        System.out.println("   姓名\t数学\t\t语文\t\t英语\t\t物理\t\t总成绩");
        for (StudentVo studentVo : studentVos) {
            System.out.println(studentVo);
        }
        String format = "平均成绩 %.3f\t%.3f\t%.3f\t%.3f\t%.3f";
        int size = studentVos.size();
        System.out.println(String.format(format, sumMath / size, sumChinese / size, sumEnglish / size, sumPhysical / size, sumScore / size));
        //
        // for (ScoreVo scoreVo : scoreList) {
        //     System.out.println(scoreVo.toString());
        // }
    }


    public static List<ScoreVo> getScoreList() {
        List<ScoreVo> scoreList = new ArrayList<>();
        ShowMeBug showMeBug = new ShowMeBug();
        scoreList.add(showMeBug.new ScoreVo("张三", "语文", 80));
        scoreList.add(showMeBug.new ScoreVo("张三", "物理", 76));
        scoreList.add(showMeBug.new ScoreVo("李四", "语文", 78));
        scoreList.add(showMeBug.new ScoreVo("茅十八", "英语", 65));
        scoreList.add(showMeBug.new ScoreVo("李四", "数学", 88));
        scoreList.add(showMeBug.new ScoreVo("李四", "物理", 87));
        scoreList.add(showMeBug.new ScoreVo("王五", "语文", 67));
        scoreList.add(showMeBug.new ScoreVo("张三", "数学", 76));
        scoreList.add(showMeBug.new ScoreVo("李四", "英语", 89));
        scoreList.add(showMeBug.new ScoreVo("王五", "数学", 65));
        scoreList.add(showMeBug.new ScoreVo("赵六", "物理", 95));
        scoreList.add(showMeBug.new ScoreVo("王五", "英语", 78));
        scoreList.add(showMeBug.new ScoreVo("王五", "物理", 65));
        scoreList.add(showMeBug.new ScoreVo("赵六", "语文", 89));
        scoreList.add(showMeBug.new ScoreVo("赵六", "英语", 87));
        scoreList.add(showMeBug.new ScoreVo("黄七", "语文", 78));
        scoreList.add(showMeBug.new ScoreVo("黄七", "数学", 65));
        scoreList.add(showMeBug.new ScoreVo("刘八", "英语", 87));
        scoreList.add(showMeBug.new ScoreVo("张三", "英语", 56));
        scoreList.add(showMeBug.new ScoreVo("黄七", "物理", 76));
        scoreList.add(showMeBug.new ScoreVo("刘八", "数学", 89));
        scoreList.add(showMeBug.new ScoreVo("黄七", "英语", 98));
        scoreList.add(showMeBug.new ScoreVo("刘八", "语文", 56));
        scoreList.add(showMeBug.new ScoreVo("刘八", "物理", 76));
        scoreList.add(showMeBug.new ScoreVo("钱九", "语文", 88));
        scoreList.add(showMeBug.new ScoreVo("钱九", "数学", 67));
        scoreList.add(showMeBug.new ScoreVo("茅十八", "数学", 43));
        scoreList.add(showMeBug.new ScoreVo("钱九", "英语", 75));
        scoreList.add(showMeBug.new ScoreVo("茅十八", "语文", 45));
        scoreList.add(showMeBug.new ScoreVo("茅十八", "物理", 56));

        return scoreList;

    }

    private class ScoreVo {
        public String studentName;
        public String courseName;
        public double score;

        public ScoreVo(String studentName, String courseName, double score) {
            this.studentName = studentName;
            this.courseName = courseName;
            this.score = score;
        }

        public String toString() {
            return this.studentName + "\t" + this.courseName + "\t" + this.score;
        }
    }

    private class StudentVo {
        private String name;
        private double chineseScore;
        private double mathScore;
        private double englishScore;
        private double physicalScore;
        private double totalScore;

        public StudentVo() {

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getChineseScore() {
            return chineseScore;
        }

        public void setChineseScore(double chineseScore) {
            this.chineseScore = chineseScore;
        }

        public double getMathScore() {
            return mathScore;
        }

        public void setMathScore(double mathScore) {
            this.mathScore = mathScore;
        }

        public double getEnglishScore() {
            return englishScore;
        }

        public void setEnglishScore(double englishScore) {
            this.englishScore = englishScore;
        }

        public double getPhysicalScore() {
            return physicalScore;
        }

        public void setPhysicalScore(double physicalScore) {
            this.physicalScore = physicalScore;
        }

        public double getTotalScore() {
            return totalScore;
        }

        public void setTotalScore(double totalScore) {
            this.totalScore = totalScore;
        }

        @Override
        public String toString() {

            String format = "%5s" + "\t" +
                    ((this.mathScore == 0) ? "\t\t" : this.mathScore + "\t") +
                    ((this.chineseScore == 0) ? "\t\t" : this.chineseScore + "\t") +
                    ((this.englishScore == 0) ? "\t\t" : this.englishScore + "\t") +
                    ((this.physicalScore == 0) ? "\t\t" : this.physicalScore + "\t") +
                    ((this.totalScore == 0) ? "\t\t" : this.totalScore);

            return String.format(format, this.name);
        }
    }
}

import java.util.*;


/*
    思考：
        方法一： 二维数组存放（缺点：数据量大了占用空间）：横轴和纵轴，横纵初始都为0，遍历横纵轴，标记出包含在字典里的数组，标记为1。
                因为要匹配，所以横轴的第一个位置必定有一个纵轴为1，
                纵轴最后一个值必定有一个横轴为1。这样可以通过最后一个纵轴看是往前递归（下一个的纵轴为当前横轴减1）。


        方法二：采用放入队列匹配的方式，匹配一组后出队列，对空间消耗小。循环字典dict,将字典与字符串s匹配，记录出现到位置，放入队列Q，当队列为s.length时，返回true，否则返回false


        下面代码采用方法二。


  */

public class Participle {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要分词的字符串并回车:");
        String participleStr = sc.nextLine();  //读取字符串型输入
        System.out.println("请输入要匹配的字典列表并回车，结束输入'#'（#不放入字典） ");
        List<String> dict = new ArrayList<String>();
        String dictStr = sc.nextLine();
        do {
            dict.add(dictStr);
            dictStr = sc.nextLine();
        }while (!"#".equals(dictStr)); // 换行输入#表示结束，#不放入字典

//        String participleStr  = "ABCDEF";
//        List<String> dict = new ArrayList<String>();
//        dict.add("AB");
//        dict.add("CD");
//        dict.add("EF");

        boolean wordBreakFlag =  prticiple(participleStr, dict);

        if(wordBreakFlag){
            System.out.println("字典匹配成功");
        }else {
            System.out.println("字典匹配失败");
        }

    }



    public static boolean prticiple(String s, List<String> dict) {
        if(s == null || s.length() == 0) {
            return false;
        }

        List<String> list = new ArrayList<String>(dict);
        Queue<Integer> queue = new LinkedList();
        int[] prticiple = new int[s.length()+1];
        int t = 0;
        do {
            if(queue != null && queue.size() >0){
                t = queue.remove();  //移除已匹配的位置
            }
            if (t == s.length()) {  //匹配的位置
                return true;
            }
            if (prticiple[t] == 0){// //未匹配的位置进行匹配
                prticiple[t] = 1; //正在进行匹配的位置进行标记，避免重复
                String temp = s.substring(t); //取出要匹配的字符串
                for (int i = 0; i < list.size(); i++) { //循环判断字典，进行匹配
                    if ((temp.length() >= list.get(i).length())
                            && (temp.indexOf(list.get(i)) == 0)) {//截取后的剩余字段大于等于字典中的长度，且匹配的首个位置是0，否则无法不匹配
                        queue.add(t + list.get(i).length());         //存放处理后的起始位置
                    }
                }
            }
        } while(!queue.isEmpty()); // 当队列空则退出，返回false（未匹配成功）
        return false;
    }



}

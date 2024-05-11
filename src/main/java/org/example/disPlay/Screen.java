package org.example.disPlay;

import org.example.entity.Commodity;
import org.example.entity.ZhengCe;

import java.util.List;


//这里的代码模拟的是前端代码
public class Screen {

    //显示主界面
    public void mianScreen(List<ZhengCe> zhengCeList,ZhengCe zhengCe1,ZhengCe zhengCe2){
        //显示界面代码
        System.out.println("==================================================");
        System.out.println("欢迎使用本系统，根据相关提示进行输入操作，输入1则进行购买商品，输入2则添加商品，输入3则选择提供的优惠折扣");
        System.out.print("今日商店优惠政策：");
        StringBuffer sb=new StringBuffer();
        for (ZhengCe zhengCe : zhengCeList) {
            //优惠政策
            if (zhengCe.getId().equals(zhengCe1.getId())){
                sb.append(zhengCe1.getText()+"，");
            }
            if (zhengCe.getId().equals(zhengCe2.getId())){
                sb.append(zhengCe2.getText()+"，");
            }
        }
        if (sb.length()>0){
            sb.replace(sb.length()-1,sb.length(),"。");
            System.out.println(sb);
        }else {
            System.out.println("暂无");
        }
        System.out.println("1、购买商品");
        System.out.println("2、添加商品");
        System.out.println("3、优惠折扣");
        System.out.println("===================================================");
    }

    //消费界面
    public void consumptionScreen(List<Commodity> list){
        System.out.println("====================");
        System.out.println("请根据需要购买相关的商品，输入操作(1=8,2=7)");
        for (Commodity commodity : list) {
            System.out.println(commodity.getId()+"、"+commodity.getName()+" "+commodity.getPrice()+"元/斤");
        }
        int size = list.size()+1;
        System.out.println(size+"、返回上一级");
        System.out.println("====================");
    }

    public void SelectZhengceScreen(List<ZhengCe> zhengCeList,ZhengCe zhengCe1,ZhengCe zhengCe2){
        System.out.println("==============");
        System.out.println("请选择优惠策略，输入对应的编号选择，如果需要两个策略，则将将两个策略编号输入");
        System.out.print("正在使用的优惠政策：");
        StringBuffer sb=new StringBuffer();
        for (ZhengCe zhengCe : zhengCeList) {
            //优惠政策
            if (zhengCe.getId().equals(zhengCe1.getId())){
                sb.append(zhengCe1.getText()+"，");
            }
            if (zhengCe.getId().equals(zhengCe2.getId())){
                sb.append(zhengCe2.getText()+"，");
            }
        }
        if (sb.length()>0){
            sb.replace(sb.length()-1,sb.length(),"。");
            System.out.println(sb);
        }else {
            System.out.println("暂无");
        }
        System.out.println();
        System.out.println("1、添加政策：草莓打8折");
        System.out.println("2、添加政策：购物满100-10");
        System.out.println("3、取消所有优惠策略");
        System.out.println("4、不保存，返回上一级");
        System.out.println("==============");
    }

    public void addCommodityScreen(){
        System.out.println("==============");
        System.out.println("请输入添加的商品名字和价格(苹果：10),或者输入4进行返回");
        System.out.println("商品：单价");
        System.out.println("==============");
    }
}

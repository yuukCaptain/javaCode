package org.example;


import org.example.disPlay.Screen;
import org.example.entity.Commodity;
import org.example.entity.Menu;
import org.example.entity.ResultVo;
import org.example.entity.ZhengCe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {

        List<Commodity> commodityList = new ArrayList<>();
        List<Menu> menuList = new ArrayList<>();
        List<ZhengCe> zhengCeList = new ArrayList<>();


        //启动初始化
        Commodity commodity1 = new Commodity();
        commodity1.setId("1");
        commodity1.setName("苹果");
        commodity1.setPrice(8);

        Commodity commodity2 = new Commodity();
        commodity2.setId("2");
        commodity2.setName("草莓");
        commodity2.setPrice(13);

        commodityList.add(commodity1);
        commodityList.add(commodity2);

        Menu menu1 = new Menu();
        menu1.setMenuName("1、购买商品");
        menu1.setNext("1");


        Menu menu2 = new Menu();
        menu2.setMenuName("2、添加商品");
        menu2.setNext("2");


        Menu menu3 = new Menu();
        menu3.setMenuName("3、优惠折扣");
        menu3.setNext("3");


        menuList.add(menu1);
        menuList.add(menu2);
        menuList.add(menu3);

        //优惠策略
        ZhengCe zhengCe1 = new ZhengCe();
        zhengCe1.setId("1");
        zhengCe1.setText("超市做促销活动，草莓限时打 8 折");


        ZhengCe zhengCe2 = new ZhengCe();
        zhengCe2.setId("2");
        zhengCe2.setText("超市做促销活动，购物满 100 减 10 块");

        //后端代码
        Check check = new Check();
        //前端代码
        Screen screen = new Screen();

        //模拟spring boot 启动
        while (true) {
            //主界面
            screen.mianScreen(zhengCeList, zhengCe1, zhengCe2);
            System.out.println("请输入相关操作:");
            Scanner scanner = new Scanner(System.in);

            //模拟用户使用 系统 校验命令
            if (scanner.hasNextLine()) {
                ResultVo result = check.mainMethod(scanner.next(), menuList);
                if (result.getResult()) {

                    if ("1".equals(result.getResultString())) {
                        while (true) {
                            //进入购买界面
                            screen.consumptionScreen(commodityList);
                            scanner = new Scanner(System.in);
                            ResultVo resultVo = check.consumptionMethod(scanner.next(), commodityList, zhengCeList);
                            if (resultVo.getResult()) {
                                System.out.println("您本次消费了" + resultVo.getResultString());
                                break;
                            } else {
                                if (("返回上一级").equals(resultVo.getResultString())) {
                                    break;
                                } else {
                                    System.out.flush();
                                    if (resultVo.getResultString() != null) {
                                        System.out.println(resultVo.getResultString());
                                    } else {
                                        System.out.println("命令不正确，请根据相关指令输入");
                                    }
                                }
                            }
                        }
                    }

                    if ("2".equals(result.getResultString())) {
                        while (true) {
                            //进入添加商品界面
                            screen.addCommodityScreen();
                            scanner = new Scanner(System.in);
                            ResultVo resultVo = check.addCommodityMethod(scanner.next(), commodityList);
                            if (resultVo.getResult()) {
                                System.out.println(resultVo.getResultString());
                                break;
                            } else {
                                if (("返回上一级").equals(resultVo.getResultString())) {
                                    break;
                                } else {
                                    System.out.println("命令不正确，请根据相关指令输入");
                                }
                            }
                        }
                    }

                    if ("3".equals(result.getResultString())) {
                        while (true) {
                            screen.SelectZhengceScreen(zhengCeList, zhengCe1, zhengCe2);
                            scanner = new Scanner(System.in);
                            ResultVo resultVo = check.updateZhengce(scanner.next(), zhengCeList, zhengCe1, zhengCe2);
                            if (resultVo.getResult()) {
                                System.out.println(resultVo.getResultString());
                                break;
                            } else {
                                if (("返回上一级").equals(resultVo.getResultString())) {
                                    break;
                                } else {
                                    System.out.println("命令不正确，请根据相关指令输入");
                                }
                            }
                        }
                    }
                } else {
                    System.out.println("命令不正确，请根据相关指令输入");
                }
            }
        }
    }
}
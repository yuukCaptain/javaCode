package org.example;

import org.example.entity.Commodity;
import org.example.entity.Menu;
import org.example.entity.ResultVo;
import org.example.entity.ZhengCe;

import java.util.List;

public class Check {

    //主菜单
  public ResultVo mainMethod(String command,List<Menu> menuList){
      ResultVo result=new ResultVo();
      for (Menu menu : menuList) {
          if (menu.getNext().equals(command)){
              result.setResult(true);
              result.setResultString(menu.getNext());
              return result;
          }
      }
      result.setResult(false);
      return result;
  }

  //购买商品
  public ResultVo consumptionMethod(String command, List<Commodity> list, List<ZhengCe> zhengCeList){
      ResultVo result=new ResultVo();
      double sunMoney=0.0;
      if (command!=null&& !command.isEmpty()){
          try {
              if (command.equals((list.size()+1)+"")){
                  result.setResult(false);
                  result.setResultString("返回上一级");
                  return result;
              }
              //拆分购买商品
              String[] split = command.split(",");
              if (split.length>0){
                  //拆分商品数量
                  for (String s : split) {
                      String[] split1 = s.split("=");
                      if (split1.length==2){
                          for (Commodity commodity : list) {
                              if (commodity.getId().equals(split1[0])){
                                  //单价
                                  Double price = commodity.getPrice();
                                  if (price>0) {
                                      //数量
                                      int i = Integer.valueOf(split1[1]);
                                      //查看是否商品类型优惠
                                      for (ZhengCe zhengCe : zhengCeList) {
                                          if (zhengCe.getId().equals("1") && commodity.getName().equals("草莓")) {
                                              price = price * 0.8;
                                          }
                                      }
                                      sunMoney = sunMoney + price * i;
                                  }else {
                                      result.setResult(false);
                                      result.setResultString("请输入正整数");
                                      return result;
                                  }
                              }
                          }
                      }else {
                          result.setResult(false);
                          return result;
                      }
                  }
                  //查看是否有满减类型优惠
                  for (ZhengCe zhengCe : zhengCeList) {
                      if (zhengCe.getId().equals("2")&&sunMoney>100){
                          sunMoney=sunMoney-10;
                      }
                  }
                  result.setResult(true);
                  result.setResultString(sunMoney+"");
                  return result;
              }
          } catch (NumberFormatException e) {
              result.setResult(false);
              return result;
          }
      }
      result.setResult(false);
      return result;
  }

  //选择优惠
  public ResultVo updateZhengce(String command,List<ZhengCe> list,ZhengCe zhengCe1,ZhengCe zhengCe2){
      ResultVo result=new ResultVo();
      try {
          if (command!=null&& !command.isEmpty()){
              //不保存直接返回
              if (command.contains("4")){
                  result.setResult(false);
                  result.setResultString("返回上一级");
                  return result;
              }

              String[] split = command.split("");

              for (String s : split) {

                  if ("1".equals(s)){
                      boolean b=true;
                      for (ZhengCe zhengCe : list) {
                          if (zhengCe.getId().equals("1")){
                              b=false;
                              break;
                          }
                      }
                      if (b){
                          list.add(zhengCe1);
                      }
                  }

                  if ("2".equals(s)){
                      boolean b=true;
                      for (ZhengCe zhengCe : list) {
                          if (zhengCe.getId().equals("2")){
                              b=false;
                              break;
                          }
                      }
                      if (b){
                          list.add(zhengCe2);
                      }
                  }

                  if ("3".equals(s)){
                      list.clear();
                  }

                  result.setResult(true);
                  result.setResultString("已经修改优惠政策");
                  return result;
              }
          }
          result.setResult(false);
          return result;
      } catch (Exception e) {
          result.setResult(false);
          return result;
      }
  }

  //添加商品
  public ResultVo addCommodityMethod(String command,List<Commodity> list){
      ResultVo result=new ResultVo();
      if (command!=null&&!command.isEmpty()){
          if ("4".equals(command)){
              result.setResult(false);
              result.setResultString("返回上一级");
              return result;
          }else {
              try {
                  String[] split = command.split("：");
                  if (split.length==2){
                      Double v = Double.valueOf(split[1]);
                      Commodity commodity=new Commodity();
                      int id = list.size() + 1;
                      commodity.setId(id+"");
                      commodity.setName(split[0]);
                      commodity.setPrice(v);
                      list.add(commodity);
                      result.setResult(true);
                      result.setResultString("添加新商品成功");
                      return result;
                  }
              } catch (NumberFormatException e) {
                  result.setResult(false);
                  return result;
              }
          }
      }
      result.setResult(false);
      return result;
  }
}

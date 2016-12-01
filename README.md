# BagdeView
![image](https://github.com/crazyqiang/BadgeView/blob/master/Picture.png)   

##How to use

     new BadgeViewPro(this).setStrColor(Color.parseColor("#ffffff"))//文本字体颜色
            .setStrSize(10)//文本字体大小 
            .setMargin(15, 0, 15, 0)//目标View的Margin
            .setStrBgColor(Color.parseColor("#000000"))//文本背景颜色
            .setStrText("99+")//设置文本
            .setShape(BadgeViewPro.SHAPE_OVAL)//文本背景形状
            .setBgGravity(Gravity.CENTER)//文本背景位置
            .setTargetView(targetView);

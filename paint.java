import java.awt.*;
import java.awt.event.*;
import java.util.*;
class drawingBoard extends Canvas
{
private static drawingBoard db;
private int lastClickedXLocation,lastClickedYLocation;
drawingBoard()
{
db=this;
lastClickedXLocation=0;
lastClickedYLocation=0;
this.setBackground(Color.gray);
this.setForeground(Color.red);
}
public boolean mouseDown(Event e,int currentXLocation,int currentYLocation)
{
lastClickedXLocation=currentXLocation;
lastClickedYLocation=currentYLocation;
return true;
}
public boolean mouseDrag(Event e,int currentXLocation,int currentYLocation)
{
Graphics g=getGraphics();
g.drawLine(lastClickedXLocation,lastClickedYLocation,currentXLocation,currentYLocation);
lastClickedXLocation=currentXLocation;
lastClickedYLocation=currentYLocation;
return true;
}
public static void set(int i)
{
if(i==1)
{
db.setForeground(Color.red);
}
else if(i==2)
{
db.setForeground(Color.blue);
}
else if(i==3)
{
db.setForeground(Color.green);
}
else if(i==4)
{
db.setForeground(Color.yellow);
}
}
}
class panel1 extends Panel
{
private drawingBoard db;
panel1()
{
setLayout(new BorderLayout());
add(new drawingBoard(),BorderLayout.CENTER);
}
}
class panel2 extends Panel
{
panel2()
{
}
public void paint(Graphics g)
{
g.setColor(Color.black);
g.drawRect(200,400,100,250);
}
}
class panelred extends Panel
{
panelred()
{
}
public void paint(Graphics g)
{
g.setColor(Color.red);
g.fillRect(10,10,20,40);
}
public boolean mouseDown(Event e,int cx,int cy)
{
if(cx>=10 && cx<=30 && cy>=10 && cy<=50)
{
drawingBoard.set(1);
}
return true;
}
}
class panelblue extends Panel
{
panelblue()
{
}
public void paint(Graphics g)
{
g.setColor(Color.blue);
g.fillRect(10,10,20,40);
}
public boolean mouseDown(Event e,int cx,int cy)
{
if(cx>=10 && cx<=30 && cy>=10 && cy<=50)
{
drawingBoard.set(2);
}
return true;
}
}
class panelgreen extends Panel
{
panelgreen()
{
}
public void paint(Graphics g)
{
g.setColor(Color.green);
g.fillRect(10,10,20,40);
}
public boolean mouseDown(Event e,int cx,int cy)
{
if(cx>=10 && cx<=30 && cy>=10 && cy<=50)
{
drawingBoard.set(3);
}
return true;
}
}
class panelyellow extends Panel
{
panelyellow()
{
}
public void paint(Graphics g)
{
g.setColor(Color.yellow);
g.fillRect(10,10,20,40);
}
public boolean mouseDown(Event e,int cx,int cy)
{
if(cx>=10 && cx<=30 && cy>=10 && cy<=50)
{
drawingBoard.set(4);
}
return true;
}
}
class paintBrush extends Frame
{
private Label l1;
paintBrush()
{
panel1 p1=new panel1();
panel2 p2=new panel2();
panelred pr=new panelred();
panelblue pb=new panelblue();
panelgreen pg=new panelgreen();
panelyellow py=new panelyellow();
setLayout(new BorderLayout());
add(p2,BorderLayout.WEST);
add(p1,BorderLayout.CENTER);
p2.setPreferredSize(new Dimension(40,50));
p2.setLayout(new GridLayout(4,1,0,20));
p2.add(pr);
p2.add(pb);
p2.add(pg);
p2.add(py);
setLocation(10,10);
setSize(500,650);
setVisible(true);
}
}
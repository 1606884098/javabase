package patterns.structural.composite;

/**
 * what:组合模式（Composite Pattern），又叫部分整体模式，是用于把一组相似的对象当作一
 * 个单一的对象。组合模式依据树形结构来组合对象，用来表示部分以及整体层次。它创建了对象
 * 组的树形结构。
 * why:它在我们树型结构的问题中，模糊了简单元素和复杂元素的概念，客户程序可以向处理简单
 * 元素一样来处理复杂元素，从而使得客户程序与复杂元素的内部结构解耦。
 * 1.部分、整体场景，如树形菜单，文件、文件夹的管理。
 * 2.location
 * how:1、您想表示对象的部分-整体层次结构（树形结构）。
 * 2、您希望用户忽略组合对象与单个对象的不同，用户将统一地使用组合结构中的所有对象。
 * example:雇员
 *雇员类：employee 树形接口数据 定义基本操作的方法 添加删除等
 */
public class CompositeApp {

	public static void main(String[] args) {
		Employee CEO = new Employee("John","CEO", 30000);

	      Employee headSales = new Employee("Robert","Head Sales", 20000);

	      Employee headMarketing = new Employee("Michel","Head Marketing", 20000);

	      Employee clerk1 = new Employee("Laura","Marketing", 10000);
	      Employee clerk2 = new Employee("Bob","Marketing", 10000);

	      Employee salesExecutive1 = new Employee("Richard","Sales", 10000);
	      Employee salesExecutive2 = new Employee("Rob","Sales", 10000);

	      CEO.add(headSales);
	      CEO.add(headMarketing);

	      headSales.add(salesExecutive1);
	      headSales.add(salesExecutive2);

	      headMarketing.add(clerk1);
	      headMarketing.add(clerk2);

	      //打印该组织的所有员工
	      System.out.println(CEO); 
	      for (Employee headEmployee : CEO.getSubordinates()) {
	         System.out.println(headEmployee);
	         for (Employee employee : headEmployee.getSubordinates()) {
	            System.out.println(employee);
	         }
	      }        
	   }
	}

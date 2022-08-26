package org.system;
		/*Class        :Desktop
     	Methods   :desktopSize()

		Description:
		create above 2 class and call all your class methods into the Desktop using single inheritance.*/

public class Desktop extends Computer{
		public void desktopSize() {
			System.out.println("desktopSize is 13.3 inch");
			
		}
	public static void main(String[] args) {

		Desktop Data=new Desktop();
		Data.computerModel();
		Data.desktopSize();
	}

}

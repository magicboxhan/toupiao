package hq.hq.toupiao;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		HttpTest h = new HttpTest();
		try {
			h.memberTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		int ip1 = 0;
//		int ip2 = 0;
//		String ipString = "";
//		Random r=new java.util.Random();
//		while(true){
//			int randomIndex_ip1 = Math.abs(r.nextInt()) % 119;
//			int randomIndex_ip2 = Math.abs(r.nextInt()) % 255;
//			ip1 = randomIndex_ip1 + 137;
//			ip2 = randomIndex_ip2 + 1;
//			Date date = new Date();
//			ipString = String.format("61.155.%d.%d", ip1, ip2);
//			try{
//				System.out.println();
//				System.out.println();
//				System.out.println(String.format("%s: Using IP: %s", date.toString(), ipString));
//				h.toupiao(ipString);
//				Thread.sleep(20000);
//			}catch(Exception e){
//				e.printStackTrace();
//				continue;
//			}
			
//			for(ip1=137;ip1<=255;ip1++){
//				for(ip2=1;ip2<=255;ip2++){
//					try{
//						Thread.sleep(10000);
//						ipString = String.format("61.155.%d.%d", ip1, ip2);
//						System.out.println(String.format("Using IP: %s", ipString));
//						h.toupiao(ipString);
//					}catch(Exception e){
//						e.printStackTrace();
//						continue;
//					}
//				}
//			}
		}
    }
//}

package paohaijiao.pockbxo.hadoop.rpc;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

public class UserLoginController {

	
	
	public static void main(String[] args) throws Exception {
		
		Configuration conf = new Configuration();
		LoginServiceInterface loginServiceImpl = RPC.getProxy(LoginServiceInterface.class, 1L, new InetSocketAddress("yun12-01", 10000), conf);
		
		String res = loginServiceImpl.login("angelababy", "123");
		
		System.out.println(res);
		
	}
	
	
}

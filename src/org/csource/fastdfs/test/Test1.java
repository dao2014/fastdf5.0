
package org.csource.fastdfs.test;

import java.io.*;
import java.net.*;
import java.util.*;
import org.csource.common.*;
import org.csource.fastdfs.*;

public class Test1
{
  public static void main(String args[])
  {
  	try
  	{
		ClientGlobal.init("D:\\myWork\\java\\sibu\\fastdfs\\src\\fdfs_client.conf");
		System.out.println("network_timeout=" + ClientGlobal.g_network_timeout + "ms");
		System.out.println("charset=" + ClientGlobal.g_charset);
  		
		TrackerGroup tg = new TrackerGroup(new InetSocketAddress[]{new InetSocketAddress("115.29.113.54", 22122)});
		TrackerClient tc = new TrackerClient(tg);
		
		TrackerServer ts = tc.getConnection();
		if (ts == null)
		{
			System.out.println("getConnection return null");
			return;
		}

		StorageServer ss = tc.getStoreStorage(ts);
		if (ss == null)
		{
			System.out.println("getStoreStorage return null");
		}
		
		StorageClient1 sc1 = new StorageClient1(ts, ss);
		
		NameValuePair[] meta_list = null;  //new NameValuePair[0];
		String item = "D:\\1027163303.png";
		String fileid = sc1.upload_file1(item, "png", meta_list); //�����쳣
		
		System.out.println("Upload local file "+item+" ok, fileid="+fileid);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	
	}
}

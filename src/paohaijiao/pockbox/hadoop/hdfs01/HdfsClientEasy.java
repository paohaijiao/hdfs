package paohaijiao.pockbox.hadoop.hdfs01;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.junit.Before;
import org.junit.Test;

public class HdfsClientEasy {

	
	private FileSystem fs = null;
	
	@Before
	public void getFs() throws IOException{
		
		//get a configuration object
		Configuration conf = new Configuration();
		//to set a parameter, figure out the filesystem is hdfs
		conf.set("fs.defaultFS", "hdfs://yun12-01:9000/");
		conf.set("dfs.replication","1");
		
		//get a instance of HDFS FileSystem Client
		fs = FileSystem.get(conf);
		
	}
	
	@Test
	public void testUpload() throws IllegalArgumentException, IOException{
		
		fs.copyFromLocalFile(new Path("/home/hadoop/jdk.download"), new Path("/aa/bb"));
		
	}
	
	
	@Test
	public void testRmfile() throws IllegalArgumentException, IOException {
		
		boolean res = fs.delete(new Path("/aa/bb"), true);
		
		System.out.println(res?"delete is successfully :)":"it is failed :(");
		
	}
	
	
	@Test
	public void testMkdir() throws IllegalArgumentException, IOException{
		
		fs.mkdirs(new Path("/aa/bb"));
		
		
	}
	
	@Test
	public void testRename() throws IllegalArgumentException, IOException{
		
		fs.rename(new Path("/jdk.tgz"), new Path("/jdk.tgz.rename"));
		
	}
	
	@Test
	public void testListFiles() throws FileNotFoundException, IllegalArgumentException, IOException{
		
		
		RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"), true);

		while(listFiles.hasNext()){
			
			LocatedFileStatus file = listFiles.next();
			
			System.out.println(file.getPath().getName());
			
		}
		
		System.out.println("--------------------------------------------");
		
		
		FileStatus[] status = fs.listStatus(new Path("/"));
		for(FileStatus file: status){
			
			System.out.println(file.getPath().getName() + "   " + (file.isDirectory()?"d":"f"));
			
			
		}
		
		
		
		
	}
	
	
	
	
}

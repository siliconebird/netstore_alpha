package com.turnrut.controler;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.turnrut.common.BookPage;
import com.turnrut.domain.Book;
import com.turnrut.domain.Category;
import com.turnrut.service.BusinessService;
import com.turnrut.service.Impl.BusinessServiceImpl;
import com.turnrut.utils.FillBeanUtil;
import com.turnrut.utils.dirUtil;

/**
 * Servlet implementation class ControlerServlet
 */
@WebServlet("/Manager/ControlerServlet")
public class ControlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String operation;
	private BusinessService bs = new BusinessServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		operation = request.getParameter("op");
		if("add".equals(operation)){
			addCategory(request,response);
		}else if ("querycategory".equals(operation)) {
			queryCategory(request,response);
		}else if ("del".equals(operation)) {
			delCategory(request,response);
		}else if ("addbooksign".equals(operation)) {
			addBooksign(request,response);
		}else if ("addbook".equals(operation)) {
			addBook(request,response);
		}else if ("querybook".equals(operation)) {
			queryBook(request,response);
		}else if ("delbook".equals(operation)) {
			delBook(request,response);
		}
	}

	

	private void delBook(HttpServletRequest request, HttpServletResponse response) {
		String bookID = request.getParameter("id");
		bs.deleteBookById(bookID);
		request.setAttribute("msg", "图书删除成功");
		try {
			request.getRequestDispatcher("/Manager/msg.jsp").forward(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void queryBook(HttpServletRequest request, HttpServletResponse response) {
		String pageIndex = request.getParameter("pageIndex");
		String offset = request.getParameter("offset");
		BookPage page = bs.findPageBooks(pageIndex, offset);
		page.setUrl("/Manager/ControlerServlet?op=querybook");
		request.setAttribute("page", page);
		request.setAttribute("bpageIndex", pageIndex);
		request.setAttribute("boffset", offset);
		try {
			request.getRequestDispatcher("/Manager/showbooks.jsp").forward(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void addBook(HttpServletRequest request, HttpServletResponse response) {
			boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
			if(isMultiPart){
				DiskFileItemFactory factory = new DiskFileItemFactory();
				//可以继续对factory 属性进行修改 例如缓存与缓存地址等。
				//factory.setRepository(new File(getServletContext().getRealPath("/")+"/temp"));
				ServletFileUpload upload = new ServletFileUpload(factory);
				//设置最大上传大小
				upload.setSizeMax(4*1024*1024);
				try {
					List<FileItem> files = upload.parseRequest(request);
					Book book = new Book();
					for(FileItem item:files){
						if(!item.isFormField()){
							//获得文件名
							String fileName = item.getName();
							if(fileName!=null&&!fileName.trim().equals("")){
								String extendFileName = FilenameUtils.getExtension(fileName);
								String newFileName = UUID.randomUUID().toString()+"."+extendFileName;
								//创建上传目录
								String storePath = getServletContext().getRealPath("/image");
								String subStorePath = dirUtil.mkdir(storePath,newFileName);
								book.setPhotoName(newFileName);
								book.setPhotoPath(subStorePath);
								item.write(new File(storePath+subStorePath+"/"+newFileName));
								System.out.println(storePath+subStorePath+"/"+newFileName);
							}
						}else{
							String name = item.getFieldName();
							String value = item.getString(request.getCharacterEncoding());
							BeanUtils.copyProperty(book, name, value);
						}
					}
					bs.addBook(book);
					request.setAttribute("msg", "存储成功！");
					request.getRequestDispatcher("/Manager/msg.jsp").forward(request, response);
				} catch (Exception e) {
							throw new RuntimeException(e);
				}
				
			}else{
				request.setAttribute("msg", "表单enctype属性有问题，请查看");
				try {
					request.getRequestDispatcher("/Manager/msg.jsp").forward(request, response);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
	}

	private void addBooksign(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Category> list = bs.findAllCategorys();
		request.setAttribute("list", list);
		try {
			request.getRequestDispatcher("/Manager/addbook.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	private void delCategory(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		bs.deleteCategoryById(id);
		try {
			request.setAttribute("msg", "删除分类成功！");
			request.getRequestDispatcher("/Manager/msg.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void queryCategory(HttpServletRequest request, HttpServletResponse response) {
		List<Category> categoryList = bs.findAllCategorys();
		request.setAttribute("list", categoryList);
		try {
			request.getRequestDispatcher("/Manager/showcategory.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addCategory(HttpServletRequest request, HttpServletResponse response) {
		 Category category = FillBeanUtil.fillBean(request, Category.class);
		 bs.addCategory(category);
		 try {
			request.setAttribute("msg", "添加分类成功！");
			request.getRequestDispatcher("/Manager/msg.jsp").forward(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

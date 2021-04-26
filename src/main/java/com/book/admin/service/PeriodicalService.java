package com.book.admin.service;

import com.book.admin.mapping.PeriodicalMapper;
import com.book.admin.model.Periodical;
import com.book.admin.model.User;
import com.book.admin.query.PagerHelper;
import com.book.admin.query.Queryparam;
import com.book.admin.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;

@Service
public class PeriodicalService {
    @Autowired
    private PeriodicalMapper periodicalMapper;

    public ResultVO queryByPage(Queryparam queryparam, User user) {
        queryparam.isFilterParamIsEmpty();
        List<Periodical> all = periodicalMapper.queryByPage(queryparam,user);
        int count = periodicalMapper.getCount(queryparam,user);
        PagerHelper<Periodical> periodicalPagerHelper= new PagerHelper<>(all,count, queryparam.getPageSize());
        return new ResultVO(periodicalPagerHelper);
    }

    public ResultVO examinePeriodical(Periodical periodical, User user) {
        periodical.setOperateTime(new Date());
        periodical.setUserId(user.getUserId());
        periodical.setUserName(user.getUserName());
        long i = periodicalMapper.updata(periodical);
        if (i != 0 )return new ResultVO();
        return new ResultVO("-5","修改失败");
    }

    public ResultVO downloadPeriodical(HttpServletResponse response,String urlName) {
        File file = new File("file/" + urlName);
        if(!file.exists()){
            return new ResultVO("-1","下载文件不存在");
        }
        response.reset();
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment;filename=" + urlName );

        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));) {
            byte[] buff = new byte[1024];
            OutputStream os  = response.getOutputStream();
            int i = 0;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }
        } catch (IOException e) {

            return new ResultVO("-1","下载失败");
        }
        return new ResultVO();
    }

    public ResultVO queryAllToManger(Queryparam queryparam) {
        queryparam.isFilterParamIsEmpty();
        List<Periodical> all = periodicalMapper.queryAllToManger(queryparam);
        int count = periodicalMapper.getToMangerCount(queryparam);
        PagerHelper<Periodical> periodicalPagerHelper= new PagerHelper<>(all,count, queryparam.getPageSize());
        return new ResultVO(periodicalPagerHelper);
    }
}

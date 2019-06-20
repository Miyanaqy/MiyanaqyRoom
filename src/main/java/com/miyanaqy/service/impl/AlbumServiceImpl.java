package com.miyanaqy.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miyanaqy.bean.bo.Page;
import com.miyanaqy.bean.entity.AlbumBean;
import com.miyanaqy.bean.vo.QueryBean;
import com.miyanaqy.dao.AlbumBeanDao;
import com.miyanaqy.service.IAlbumService;

@Service
public class AlbumServiceImpl extends BaseServiceImpl implements IAlbumService {
	
	@Autowired
	private AlbumBeanDao albumDao;

	@Override
	public int add(AlbumBean bean) {
		AlbumBean result = albumDao.save(bean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public int edit(AlbumBean bean) {
		AlbumBean findBean = albumDao.findById(bean.getId()).orElse(null);
		if (findBean == null) return -2;
		findBean.setAlbumCover(bean.getAlbumCover());
		findBean.setAlbumDescribe(bean.getAlbumDescribe());
		findBean.setAlbumTitle(bean.getAlbumTitle());
		findBean.setType(bean.getType());
		AlbumBean result = albumDao.save(findBean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public int deleteById(Long albumId) {
		AlbumBean findBean = albumDao.findById(albumId).orElse(null);
		if (findBean == null) return -2;
		findBean.setDeleteFlag(1);
		AlbumBean result = albumDao.save(findBean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public AlbumBean findById(Long albumId) {
		return albumDao.findById(albumId).orElse(null);
	}

	@Override
	public Page<AlbumBean> findByPage(QueryBean query) {
//		Page<AlbumBean> page = new Page<AlbumBean>(query.getPage_index(), query.getPage_size());
//		page.setTotals(albumDao.getBeanListByCount(query));
//		if (page.getTotals() == 0)
//            page.setDatalist(new ArrayList<>());
//        else
//            page.setDatalist(albumDao.getBeanListByPage(query));
//        return page;
		return null;
	}

}

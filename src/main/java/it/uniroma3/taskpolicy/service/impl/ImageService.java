package it.uniroma3.taskpolicy.service.impl;


import it.uniroma3.taskpolicy.dao.ImageDao;
import it.uniroma3.taskpolicy.dao.impl.ImageDaoImpl;
import it.uniroma3.taskpolicy.model.Image;
import it.uniroma3.taskpolicy.model.Manuscript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

@Service
public class ImageService {


    @Autowired
    private ImageDao imageDao;

    @Autowired
    private ImageDaoImpl imageDaoImpl;

    public void getListImageProperties(String p, Manuscript manuscript) throws FileNotFoundException, IOException {
        this.imageDaoImpl.insertImage(p, manuscript);
    }

    public void updateAllImages(String p, Manuscript manuscript) throws IOException {
        this.imageDaoImpl.updateImagesAll(p, manuscript);
    }

    public void addImage(Image i) {
        imageDao.save(i);
    }

    public Image retrieveImage(long id) {
        return this.imageDao.findOne(id);
    }

    public List<Image> retrieveAllImages() {
        return this.imageDao.findAll();
    }

    public List<Image> getImagesForTypeAndManuscriptName(String type, String manuscript, int limit) {
        return this.imageDao.findImageForTypeAndManuscriptName(type, manuscript, limit);
    }

    public List<Image> getImagesFromManuscriptName(long manuscript) {
        return this.imageDao.findImageFromManuscriptName(manuscript);
    }

    public List<Image> findImageForTypeAndWidthAndManuscript(String type, String manuscript, int width, int limit) {
        return this.imageDao.findImageForTypeAndWidthAndManuscript(type, manuscript, width, limit);
    }

    public List<BigInteger> findImagesJob() { return this.imageDaoImpl.findImagesJob();}


    public List<String> findAllPages() {
        return this.imageDao.findAllPages();
    }

    public Object[] countImage() {
        return this.countImage();
    }

    public BigInteger findOneImageJob() { return this.imageDaoImpl.findOneImageJob(); }

    }

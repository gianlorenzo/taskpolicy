package it.uniroma3.taskpolicy.dao;

import it.uniroma3.taskpolicy.model.Image;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ImageDaoCustom {
    public List<Image> findImageForTypeAndManuscriptName(String type, String manuscript, int limit);

    public List<Image> findImageForTypeAndWidthAndManuscript(String type, String manuscript, int width, int limit);

    public List<String> findAllManuscript();

    public List<String> findAllPages();

    public Object[] countImage();

    public List<Image> findImageFromManuscriptName(long manuscript);

    public List<BigInteger> findImagesJob();

    public BigInteger findOneImageJob();


}

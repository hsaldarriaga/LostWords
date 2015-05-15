package com.movil.pixelcode.lostwords.Models;

import com.movil.pixelcode.lostwords.Models.Abstracts.Score;

/**
 * Created by hass-pc on 01/05/2015.
 */
public class CategoryScore extends Score {

    private Word.CATEGORY Category;

    public CategoryScore(long Score, Word.CATEGORY Category) {
        super(Score);
        this.Category = Category;
    }

    public Word.CATEGORY getCategory() {
        return Category;
    }
}

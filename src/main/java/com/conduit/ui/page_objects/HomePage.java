package com.conduit.ui.page_objects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class HomePage {

    @FindBy(css = ".tag-default")
    private ElementsCollection tags;

    @FindBy(css = ".article-preview")
    private ElementsCollection articles;

    @FindBy(css = ".page-link")
    private ElementsCollection pageLinks;

    public List<String> getAllTags(){

        return tags.shouldHave(CollectionCondition.sizeGreaterThan(0))
                .stream()
                .map(e->e.getText().trim())
                .collect(Collectors.toList());
    }

    public HomePage verifyThatNumberOfArticlesOnPageIs(int number){

            assertThat(articles
                    .shouldHave(CollectionCondition.size(number))
                    .stream()
                    .count()).isEqualTo(number);

            return this;
    }

    public HomePage verifyThatNumberOfPagesIs(int number){

        assertThat(pageLinks
                .shouldHave(CollectionCondition.size(number))
                .stream()
                .count()).isEqualTo(number);


        return this;
    }
}

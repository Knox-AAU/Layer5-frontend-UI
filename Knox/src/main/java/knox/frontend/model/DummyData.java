package knox.frontend.model;

import java.util.ArrayList;
import java.util.List;

public class DummyData {

  // Nordjyske DummyData
  private String title; // Page title
  private String subtitle; // Page subtitle
  private String author; // Author of article
  private String date; // Date of article
  private String articleText; // Article text
  private List<String> images = new ArrayList<>(); // Images in article
  private final List<String> keywords = new ArrayList<>(); // Images in article
  private final List<Integer> relatedArticles = new ArrayList<>();
  private int uniqueId;

  public DummyData() {}

  public static DummyData CreateDummy(int id) {
    DummyData returndata = new DummyData();

    returndata.title = "Nu kommer Mariagerfjords kæledægge på museum";
    returndata.subtitle =
        "Den sejhval, der blev et tilløbsstykke i slutningen af 2018, bliver udstillet i Hobro";
    returndata.author = "Ole Fink Mejlgaard";
    returndata.date = "08. oktober 2020 kl. 08:03";
    returndata.articleText =
        "HOBRO:Mon ikke de fleste husker den hval, som i slutningen af 2018 forvildede sig ind i Mariager "
            + "Fjord og tog ophold i havnen i Hobro, hvor den i halvanden uge nåede at blive et tilløbsstykke og "
            + "blev til en godnathistorie med navnet Runa på hjemmesiden vilter.dk?\n"
            + "\n"
            + "Der blev gjort flere forsøg på at eskortere hvalen ud af fjorden, men det blev mere og mere klart, "
            + "at den sikkert var syg, og 7. december blev den så fundet død i Ørnedalsbugten i Mariager Fjord."
            + "Siden blev den obduceret på havnen i Hobro. Obduktionen afslørede, at der var tale om godt 10 meter "
            + "lang såkaldt sejhval, og det er ikke hver dag, danske farvande får sådan en besøg. Tidligere er der "
            + "kun sket to kendte strandinger af den slanke bardehval - det var ifølge Statens Naturhistoriske Museum "
            + "i 1955 i Svendborg Sund og i 1980 ved Nordals. "
            + "\n"
            + "Eksperter fra Statens Naturhistoriske Museum "
            + "konkluderede efter undersøgelserne af den døde hval, at den led af dårligt hjerte, og at hjertesygdommen "
            + "sandsynligvis havde fået den til at søge ind i smult vande."
            + "\n"
            + "To år er næsten gået, siden hvalen "
            + "satte havnen i Hobro på den anden ende, og nu vender den så tilbage til byen. Lige nu arbejdes der hårdt "
            + "på at færdiggøre en udstilling af skelettet i Det Maritime Kulturcenter. Udstillingen åbner dørene lørdag 10. oktober."
            + "Glad borgmester\n"
            + "Det er noget, der glæder Mariagerfjord Kommunes borgmester, Mogens Jespersen (V).\n"
            + "\n"
            + "- Jeg er glad for, at det er lykkedes at få sejhvalen hjem til os i Mariagerfjord. Det er helt usædvanligt, "
            + "at sejhvaler besøger danske farvande, og så er det jo bare herligt, at den nu kommer hjem til Hobro. Jeg er sikker på, "
            + "at den endnu engang bliver et kolossalt tilløbsstykke, hvor turister, skoleklasser og borgere vil besøge Det Maritime "
            + "Kulturcenter for at blive klogere på det prægtige dyr, siger borgmesteren i en pressemeddelelse.\n"
            + "\n"
            + "At hvalen først kommer \"hjem\" nu skyldes blandt andet coronavirus, der har sat en kæp i hjulet for mange ting i 2020.\n"
            + "\n"
            + "- Vi har ventet længe på, at hvalen kunne vende hjem, og nu glæder vi os over, at vi har fået en ny enestående "
            + "turistattraktion til vores kommune. Vi har haft et godt samarbejde med Mariagerfjord Kommune og Statens Naturhistoriske "
            + "Museum. Det betyder, at vi nu kan udstille sejhvalen for publikum og fortælle om dens liv på de store oceaner, forklarer "
            + "Jørgen Pontoppidan, der er formand for bestyrelsen i Det Maritime Kulturcenter.\n"
            + "\n"
            + "Kommune låner sejhvalen\n"
            + "Mariagerfjord Kommune har indgået en såkaldt udlånsaftale med Statens Naturhistoriske Museum, der løber de næste ti år. "
            + "Aftalen betyder, at kommunen er forpligtet til at udstille skelet og hjerte for offentligheden under gode og ordnede forhold. "
            + "Det sker i samarbejde med Jutlander Fonden Hobro, som gavmildt har doneret 190.000 kroner til formålet.";
    returndata.images.add(
        "https://img.nordjyske.dk/s3/nj-prod-public-images/DrhdqWEz3eKpmWMTe5QHeGHK2kI.jpg?w=960&h=540&scale=both&mode=crop");
    returndata.images.add(
        "https://img.nordjyske.dk/s3/nj-prod-public-images/J2YNvD1NwhQJrxKEfLB5NZCvaUg.jpg?w=624&scale=both&mode=crop");
    returndata.images.add(
        "https://img.nordjyske.dk/s3/nj-prod-public-images/F7LXx9sFbGFJC40CGXMidLcYDY8.jpg?w=624&scale=both&mode=crop");
    returndata.images.add(
        "https://img.nordjyske.dk/s3/nj-prod-public-images/2GTPwxHUYSW-URlzKmG1U0I1hgo.jpg?w=624&scale=both&mode=crop");
    returndata.images.add(
        "https://img.nordjyske.dk/s3/nj-prod-public-images/W_MFuFmiAYL-SawUfmcihDOsEfc.jpg?w=624&scale=both&mode=crop");

    returndata.uniqueId = id;
    returndata.title += id;
    returndata.relatedArticles.add(1);
    returndata.relatedArticles.add(3);
    returndata.relatedArticles.add(5);
    returndata.keywords.add("awesomeword");
    returndata.keywords.add("hval");
    returndata.keywords.add("coolword");

    return returndata;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSubtitle() {
    return subtitle;
  }

  public void setSubtitle(String subtitle) {
    this.subtitle = subtitle;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getArticleText() {
    return articleText;
  }

  public void setArticleText(String articleText) {
    this.articleText = articleText;
  }

  public List<String> getImages() {
    return images;
  }

  public void setImages(List<String> images) {
    this.images = images;
  }

  public int getUniqueId() {
    return uniqueId;
  }

  public List<Integer> getRelatedArticles() {
    return relatedArticles;
  }

  public List<String> getKeywords() {
    return keywords;
  }
}

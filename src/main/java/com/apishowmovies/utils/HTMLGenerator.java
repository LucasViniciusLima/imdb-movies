package com.apishowmovies.utils;


import com.apishowmovies.domain.Content;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

public class HTMLGenerator {

    Writer pWrite;

    public HTMLGenerator(PrintWriter printWriter) {
        this.pWrite = printWriter;
    }

    public void generate(List<? extends Content> listContent) throws IOException {
        pWrite.write(this.getHtmlInit());

        listContent.forEach((content) -> {
            try {
                pWrite.write("<div class=\"card col-3 m-2\" style=\"width: 18rem;\">");
                pWrite.write("<img src=\"" + content.getImage() + "\" class=\"card-img-top\" alt=\"" + content.getTitle() + "\">");
                pWrite.write("<div class=\"card-body\"><h5 class=\"card-title\">" + content.getTitle() + "</h5></div><ul class=\"list-group list-group-flush\"><li class=\"list-group-item\">Nota: " + content.getRatting());
                pWrite.write("</li><li class=\"list-group-item\">Ano: " + content.getYear() + "</li></ul></div>");
            } catch (Exception ex) {

                System.out.println("erro ao produzir html da lista");
            }
        });


        pWrite.write(this.getHtmlEnd());
    }

    private String getHtmlInit() {
        return """
                <html lang="en">
                  <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
                    <title>ImDb Bests Movies</title>
                  </head>
                  <body class="bg-dark">
                    <div class="container">
                        <h1 class="text-white mb-5">IMDB MOVIES</h1>
                        <div class="d-flex flex-wrap">
                """;
    }

    private String getHtmlEnd() {
        return """
                  </div>
                  </div>
                 </body>
                </html>
                """;
    }
}

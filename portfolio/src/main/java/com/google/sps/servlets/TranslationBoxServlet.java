package main.java.com.google.sps.servlets;

import java.io.IOException;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.translate.Translation;
import com.google.cloud.datastore.StructuredQuery;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.EntityQuery;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translate;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet({ "/translatingbox" })
public class TranslationBoxServlet extends HttpServlet{

    public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        final String originalText = request.getParameter("text");
        final Translate translate = (Translate)TranslateOptions.getDefaultInstance().getService();
        final Translation translation = translate.translate(originalText, new Translate.TranslateOption[] { Translate.TranslateOption.targetLanguage("hi") });
        final String translatedText = translation.getTranslatedText();
        final Datastore datastore = (Datastore)DatastoreOptions.getDefaultInstance().getService();
        final KeyFactory keyFactory = (KeyFactory)datastore.newKeyFactory().setKind("Translations");
        final FullEntity taskEntity = ((FullEntity.Builder)Entity.newBuilder(keyFactory.newKey()).set("finaltext", translatedText)).build();
        datastore.put(taskEntity);
        final Query<Entity> query = (Query<Entity>)((EntityQuery.Builder)((EntityQuery.Builder)Query.newEntityQueryBuilder().setKind(translatedText)).setOrderBy(StructuredQuery.OrderBy.desc("timestamp"), new StructuredQuery.OrderBy[0])).build();
        final QueryResults<Entity> results = (QueryResults<Entity>)datastore.run((Query)query);
        while (results.hasNext()) {
            final Entity entity = (Entity)results.next();
        }
        
        response.sendRedirect("https://nsharma-sps-summer22.appspot.com");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println("The translation is " + translatedText);
    }
}


package sid.org.Bcaisse.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sid.org.Bcaisse.dao.ArticleRepository;
import sid.org.Bcaisse.dto.ListArticle;
import sid.org.Bcaisse.entites.Article;
import sid.org.Bcaisse.entites.ArticleExcel;
import sid.org.Bcaisse.service.ArticleService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ArticleController {
   @Autowired
   private ArticleRepository articleRepository;
     @Autowired
    private ServletContext servletContext;
    @Autowired
    private ArticleService articleService;

    /*@GetMapping("articles/7/{code}")
    public int getCode(@PathVariable String code){
        int x = articleRepository.nbre(code);
        if(x==0) {
            return 0;
        }
        else {
            return articleRepository.max(code);
        }
    }

      @GetMapping("/articles")
      public List<Article> articleList()

      {
          return  articleRepository.findAll();
      }

      @GetMapping("/articles/f/{code}")
      public List<Article> listeArtf(@PathVariable String code){

          return articleRepository.findByCode(code);
      }

    @GetMapping("/articles/{id}")
    public ResponseEntity<Article> getArticle(@PathVariable Long id){
        Optional<Article> cat = articleRepository.findById(id);
        return cat.map(ResponseEntity::ok).orElseGet(
                ()->ResponseEntity.notFound().build());
    }
      @PostMapping("/articles")
      public  long createArticle(@RequestParam("file") MultipartFile file,
                                 @RequestParam("article") String articles) throws
                                 JsonParseException, JsonMappingException, Exception
      {
          Article arti = new ObjectMapper().readValue(articles, Article.class);
          boolean isExist = new File(servletContext.getRealPath("/Imagess/")).exists();
          if(isExist){
              new File((servletContext.getRealPath("/Imagess/"))).mkdir();
          }
          String filename = file.getOriginalFilename();
          String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
          File serverFile = new File(servletContext.getRealPath("/Imagess"+File.separator+newFileName));
          try {
              System.out.println("Image");
              FileUtils.writeByteArrayToFile(serverFile, file.getBytes());

          }catch (Exception e){
              e.printStackTrace();
          }
          arti.setFileName(newFileName);
          return articleService.save(arti);
      }

      @PutMapping("/articles/{id}")
      public Article update(@PathVariable(value = "id") Long id,@Validated @RequestBody Article article){
          // article.setId(id);
          Article cat = articleRepository.findById(id).get();
          cat.setCode(article.getCode());
          cat.setCodef(article.getCodef());
          return articleRepository.save(article);
      }


    @DeleteMapping("/articles/{id}")
    public void delete(@PathVariable(value = "id") Long id) {

        articleRepository.deleteById(id);
    }

     public void exportToExcel(HttpServletResponse httpServletResponse)throws IOException {
         httpServletResponse.setContentType("application/octet-stream");
         SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
         String currentDateTime = dataFormat.format(new Date());
         String headerkey = "Content-Disposition";
         String headerValue = "attachement ; filename=articles_"+currentDateTime+".xlsx";
         httpServletResponse.setHeader(headerkey,headerValue);
         List<Article> articles = articleRepository.findAll();
         ArticleExcel excel = new ArticleExcel(articles);
         excel.export(httpServletResponse);
     }

    @GetMapping("/imageArticles/{id}")
     public byte[] getPhoto(@PathVariable("id") Long id)throws Exception{
         Article article = articleRepository.findById(id).get();
         return Files.readAllBytes(Paths.get(servletContext.getRealPath("/Imagess")+article.getFileName()));
     }
*/

     @GetMapping("articles/7/{code}")
      public int getCode(@PathVariable String code){
          int x = articleService.nbre(code);
          if(x==0) {
              return 0;
          }
          else {
              return articleService.max(code);
          }
      }

      @GetMapping("/articles")
      public List<Article> list(){
           return articleService.getAll();
      }

      @GetMapping("/articles/f/{code}")
      public List<ListArticle> listeArtf(@PathVariable int code){
           return articleService.listArtf(code);
      }


      @GetMapping("/articles/{id}")
      public ResponseEntity<Article> post(String id){
          Optional<Article> cat = articleService.findByCode(id);
           return cat.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
      }

      @PutMapping("/articles/{code}")
      public void update(@PathVariable String code, @RequestBody Article article){
        Optional<Article> cat = articleService.findByCode(code);
        if(cat.isPresent()){
            articleService.update(code,article);
        }
      }
      @GetMapping("/imageArticles/{id}")
     public byte[] getPhoto(@PathVariable("id") Long id)throws Exception{
          Article article = articleService.findById(id).get();
          return Files.readAllBytes(Paths.get(servletContext.getRealPath("/Imagess")+article.getFileName()));
     }
     @DeleteMapping("/articles/{code}")
      public void delete(@PathVariable String code){
           articleService.delete(code);
      }
      public void exportToExcel(HttpServletResponse httpServletResponse)throws IOException {
          httpServletResponse.setContentType("application/octet-stream");
         SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
         String currentDateTime = dataFormat.format(new Date());
         String headerkey = "Content-Disposition";
         String headerValue = "attachement ; filename=articles_"+currentDateTime+".xlsx";
         httpServletResponse.setHeader(headerkey,headerValue);
         List<Article> articles = articleService.getAll();
         ArticleExcel excel = new ArticleExcel(articles);
         excel.export(httpServletResponse);
     }
     @PostMapping("/articles")
      public  long createArticle(@RequestParam("file") MultipartFile file,
                                 @RequestParam("article") String articles) throws JsonParseException,
             JsonMappingException, Exception
      {
          Article arti = new ObjectMapper().readValue(articles, Article.class);
          boolean isExist = new File(servletContext.getRealPath("/Imagess/")).exists();
          if(isExist){
              new File((servletContext.getRealPath("/Imagess/"))).mkdir();
          }
          String filename = file.getOriginalFilename();
          String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
          File serverFile = new File(servletContext.getRealPath("/Imagess"+File.separator+newFileName));
          try {
              System.out.println("Image");
              FileUtils.writeByteArrayToFile(serverFile, file.getBytes());

          }catch (Exception e){
             e.printStackTrace();
          }
          arti.setFileName(newFileName);
          return articleService.save(arti);
      }
}

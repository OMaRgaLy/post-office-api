package kz.dar.academy.controller;

import kz.dar.academy.feign.ClientFeign;
import kz.dar.academy.feign.PostFeign;
import kz.dar.academy.model.ClientModel;
import kz.dar.academy.model.DetailsModel;
import kz.dar.academy.model.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post-office")
public class PostOfficeController {

    @Autowired
    PostFeign postFeign;

    @Autowired
    ClientFeign clientFeign;

    @Autowired
    Environment env;

    @GetMapping("/check")
    public String check(){
        return "post-office-api is working at port: " + env.getProperty("local.server.port");
    }

    @GetMapping("/post/check")
    public String checkPostFeign() {
        return postFeign.checkPostCoreApi();
    }

    @GetMapping("/post/all")
    public List<PostModel> getAllPostsFeign() {
        return postFeign.getAllPosts();
    }

    @GetMapping("/post/{postId}")
    public PostModel getPostByIdFeign(@PathVariable String postId) {
        return postFeign.getPostById(postId);
    }

    @GetMapping("/client/check")
    public String checkClientFeign() {
        return clientFeign.checkClientCoreApi();
    }

    @GetMapping("/client/all")
    public List<ClientModel> getAllClientsFeign() {
        return clientFeign.getAllClients();
    }

    @GetMapping("/client/{clientId}")
    public ClientModel getClientByIdFeign(@PathVariable String clientId) {
        return clientFeign.getClientById(clientId);
    }

    @GetMapping("/post-detail/{postId}")
    public DetailsModel getPostDetails(@PathVariable String postId) {
        PostModel sendPost = postFeign.getPostById(postId);
        System.out.println(sendPost);
        ClientModel sendClient = clientFeign.getClientById(sendPost.getClientId());
        ClientModel sendReceiver = clientFeign.getClientById(sendPost.getPostRecipientId());

        return new DetailsModel(postId, sendClient, sendReceiver, sendPost.getPostItem(), sendPost.getStatus());
    }
}

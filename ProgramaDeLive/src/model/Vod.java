package model;

import java.io.Serializable;

import model.Usuarios.Streamer;

public class Vod implements Serializable{
    private String titulo;
    private String categoria;
    private Streamer streamer;

    public Vod(Streamer streamer, String titulo, String categoria) {
        this.streamer = streamer;
        this.titulo = titulo;
        this.categoria = categoria;
    }


    @Override
    public String toString() {
        return "\n # Vod [titulo = " + titulo + ", categoria = " + categoria;
    }


    //GETTERs e SETTERs
    public String getTitulo() {
        return titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public Streamer getStreamer() {
        return streamer;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setStreamer(Streamer streamer) {
        this.streamer = streamer;
    }

    
    
}

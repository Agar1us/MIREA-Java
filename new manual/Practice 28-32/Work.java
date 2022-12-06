import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Scanner;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.util.mxCellRenderer;
import org.jgrapht.Graph;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.imageio.ImageIO;

public class Work {
    public static HashMap<String, Boolean> checkDependence = new HashMap<String, Boolean>();
    public static Graph<String, DefaultEdge> g = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);

    public static void printGraph() throws IOException {
        JGraphXAdapter graphAdapter =
                new JGraphXAdapter(g);
        mxIGraphLayout layout = new mxCircleLayout(graphAdapter);
        layout.execute(graphAdapter.getDefaultParent());
        BufferedImage image =
                mxCellRenderer.createBufferedImage(graphAdapter, null, 2, Color.WHITE, true, null);
        File imgFile = new File("graph.png");
        ImageIO.write(image, "PNG", imgFile);
    }
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public static void getChildLib(String library, int level, int globalLevel) throws IOException, JSONException {
        if (level > globalLevel | checkDependence.containsKey(library))
            return;
        String url = "https://pypi.org/pypi/" + library + "/json";
        JSONObject json = readJsonFromUrl(url);
        JSONObject tmp = json.getJSONObject("info");
        try{
            if (tmp.get("requires_dist") != null) {
                g.addVertex(library);
                JSONArray list = tmp.getJSONArray("requires_dist");
                String [] childLibraries = new String[list.toList().size()];
                for (int i = 0; i < list.toList().size(); ++i){
                    childLibraries[i] = list.get(i).toString().split(" ")[0];
                    g.addVertex(childLibraries[i]);
                    g.addEdge(library, childLibraries[i]);
                }
                checkDependence.put(library, true);
                for (String el: childLibraries)
                    getChildLib(el, level + 1, globalLevel);
            }
        }
        catch(FileNotFoundException | JSONException ignored){
            return;
        }
    }

    public static boolean isLibrary(String library) throws IOException {
        try{
            JSONObject json = readJsonFromUrl("https://pypi.org/pypi/" + library + "/json");
            return true;
        }
        catch (JSONException | FileNotFoundException ignored){
            return false;
        }
    }

    public static boolean isHeight(int maxHeight){
        return maxHeight > 0;
    }

    public static void run(String library, int maxHeight) throws IOException {
        getChildLib(library, 1, maxHeight);
        printGraph();
    }
}
<h2>K-Means Algorithm</h2>
<br/>
Steps to run: (<b>Note</b>: JDK 1.8 | Java 8 and above is required)
<ul>
    <li>The `kmeans_input.txt` contains all the points as inputs to the clusters as comma separated x-axis and y-axis with each point being in a new line</li>
    <li>Compile the package `io.onclave.kmeans`</li>
    <li>The `io.onclave.kmeans.algorithm.KMeans.java` contains the `main` method. Run the corresponding .class file after compiling the source code</li>
    <li>Follow the console prompts at runtime</li>
</ul>
<br/>
Output:
<p>The algorithm would introduce random K number of centroids where K is the user input. To change the default maximum and minimum coordinate values of the centroids, change the values of `io.onclave.kmeans.api.Configuration.MAX_CENTROID_Y` and `io.onclave.kmeans.api.Configuration.MIN_CENTROID_X`. The algorithm would then reassign the clusters according to the centroids and in turn reassign the centroids according the cluster it is nearer to by finding the mean position in the cluster. The algorithm would stop iterating when the centroid positions do not change anymore.</p>
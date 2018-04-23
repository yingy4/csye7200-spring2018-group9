package regression

import org.apache.spark.mllib.classification.NaiveBayes
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.{SparkConf, SparkContext}


object Bayes   {

  def navieBayes(predictData:Seq[String]): Array[Double] ={
    val conf = new SparkConf().setAppName("Naive Bayes Test").setMaster("local")
      .set("spark.driver.allowMultipleContexts", "true")
    val sc = new SparkContext(conf)
    val dataRDD = sc.textFile("./app/regression/weather.txt")
    val parsedDataRDD = dataRDD.map { line =>
      val parts = line.split(',')
      LabeledPoint(parts(10).toDouble, Vectors.dense(Array(parts(7),parts(4)).map(_.toDouble)))
    }
    val trainRDD = parsedDataRDD
    val model = NaiveBayes.train(parsedDataRDD, lambda = 1.0, modelType = "multinomial")
   // val t =Seq("4/22/2017,10,14,7,1028.02,1029,1027,70,93,48,0","4/22/2017,10,14,7,1028.02,1029,1027,70,93,48,0")

    val dataRDD11=sc.parallelize(predictData)
    val parsedDataRDD1 = dataRDD11.map { line =>
      val parts = line.split(',')
      LabeledPoint(parts(0).toDouble, Vectors.dense(Array(parts(1),parts(4)).map(_.toDouble)))
    }
    val testRDD = parsedDataRDD1
    val predictionAndLabel = testRDD.map(p => (model.predict(p.features)))

    return predictionAndLabel.take(50)
//        val showPredict = predictionAndLabel.take(50)
//        println("Prediction" + "\t" + "Label" + "\t" + "Data")
//        for (i <- 0 to showPredict.length - 1) {
//          println(showPredict(i)._1 + "\t" + showPredict(i)._2 + "\t" + showPredict(i)._3)
//        }
//
//        val accuracy = 1.0 * predictionAndLabel.filter(x => x._1 == x._2).count() / testRDD.count()
//        println("Accuracy=" + accuracy)
  }
}

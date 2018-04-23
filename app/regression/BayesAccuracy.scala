package regression

import org.apache.log4j.{Level, Logger}
import org.apache.spark.mllib.classification.NaiveBayes
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.{SparkConf, SparkContext}

object NaiveBayesTest {
    // 设置运行环境
    val conf = new SparkConf().setAppName("Naive Bayes Test").setMaster("local")
      .set("spark.driver.allowMultipleContexts", "true")
    val sc = new SparkContext(conf)
    Logger.getRootLogger.setLevel(Level.WARN)

    // 读取样本数据并解析
    val dataRDD = sc.textFile("./app/regression/weather.txt")
    val parsedDataRDD = dataRDD.map { line =>
      val parts = line.split(',')
      LabeledPoint(parts(10).toDouble, Vectors.dense(Array(parts(7),parts(4)).map(_.toDouble)))
    }

    // 样本数据划分,训练样本占0.8,测试样本占0.2
    val dataParts = parsedDataRDD.randomSplit(Array(0.8, 0.2))
    val trainRDD = dataParts(0)
    val testRDD = dataParts(1)

    // 建立贝叶斯分类模型并训练
    val model = NaiveBayes.train(trainRDD, lambda = 1.0, modelType = "multinomial")

    // 对测试样本进行测试
    val predictionAndLabel = testRDD.map(p => (model.predict(p.features), p.label, p.features))
    val showPredict = predictionAndLabel.take(50)
    println("Prediction" + "\t" + "Label" + "\t" + "Data")
    for (i <- 0 to showPredict.length - 1) {
      println(showPredict(i)._1 + "\t" + showPredict(i)._2 + "\t" + showPredict(i)._3)
    }

    val accuracy = 1.0 * predictionAndLabel.filter(x => x._1 == x._2).count() / testRDD.count()
    println("Accuracy=" + accuracy)

}
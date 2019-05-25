package com.yhklsdf.module_home.bean

data class JobDetailsBean(val jobName: String,
                          val pay: Int,
                          val welfare: List<String>,
                          val image: Any,
                          val companyName: String,
                          val classify_1: String,
                          val classify_2: String,
                          val classify_3: Int,
                          val request : String)
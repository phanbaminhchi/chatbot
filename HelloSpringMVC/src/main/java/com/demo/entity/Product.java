package com.demo.entity;

 
import java.io.Serializable;

 
public class Product implements Serializable{
        private String proId;
        private String proName;
        private String producer;
        private int yearMaking;
        private double price;
        
        public Product() {
                super();
                // TODO Auto-generated constructor stub
        }

 
        public Product(String proId, String proName, String producer, int yearMaking, double price) {
                super();
                this.proId = proId;
                this.proName = proName;
                this.producer = producer;
                this.yearMaking = yearMaking;
                this.price = price;
        }

 
        public String getProId() {
                return proId;
        }

 
        public void setProId(String proId) {
                this.proId = proId;
        }

 
        public String getProName() {
                return proName;
        }

 
        public void setProName(String proName) {
                this.proName = proName;
        }

 
        public String getProducer() {
                return producer;
        }

 
        public void setProducer(String producer) {
                this.producer = producer;
        }

 
        public int getYearMaking() {
                return yearMaking;
        }

 
        public void setYearMaking(int yearMaking) {
                this.yearMaking = yearMaking;
        }

 
        public double getPrice() {
                return price;
        }

 
        public void setPrice(double price) {
                this.price = price;
        }    
}

 
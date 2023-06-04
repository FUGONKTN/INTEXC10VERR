package com.example.intexc10_3.service;

public class GetterService {

        private final Database db;
        private final ExcursionDao excursionDao;

        public GetterService(Database db) {
                this.db = db;
                this.excursionDao = db.excursionDao();
        }

        public String[] getQuestions(int position){
                String questone = excursionDao.getQuestioneOne(position);
                String questtwo = excursionDao.getQuestioneTwo(position);
                String questthree = excursionDao.getQuestioneThree(position);
                String[] quests = {questone, questtwo, questthree};
                return quests;
        }
        public String[] getAnswers(int position){
                String ansone = excursionDao.getAnsOne(position);
                String anstwo = excursionDao.getAnsTwo(position);
                String ansthree = excursionDao.getAnsThree(position);
                String[] ans = {ansone, anstwo, ansthree};
                return ans;
        }
        public Double[] getPoints(int position){
                Double latone = excursionDao.getLatOne(position);
                Double longone = excursionDao.getLongOne(position);
                Double lattwo = excursionDao.getLatTwo(position);
                Double longtwo = excursionDao.getLongTwo(position);
                Double latthree = excursionDao.getLatThree(position);
                Double longthree = excursionDao.getLongThree(position);
                Double[] points = {latone, longone, lattwo, longtwo, latthree, longthree};
                return points;
        }
        public String[] getInformation(int position){
                String name = excursionDao.getName(position);
                String info = excursionDao.getInfo(position);
                String[] information = {name, info};
                return information;
        }
        public void updateRes(int res, int id){
                excursionDao.updateRes(res, id);
        }
        public int getRes(int id){
              return  excursionDao.getRes(id);
        }
}

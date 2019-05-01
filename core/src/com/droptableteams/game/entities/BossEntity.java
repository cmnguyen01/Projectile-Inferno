package com.droptableteams.game.entities;

import com.droptableteams.game.LibECS.interfaces.IEntity;


    public class BossEntity implements IEntity {
        private int _id;
        private String _type;

        public BossEntity(int id){
            _id = id;
            _type = "BossEntity";
        }

        @Override
        public int getId() {
            return _id;
        }

        @Override
        public String getType() {
            return _type;
        }
    }



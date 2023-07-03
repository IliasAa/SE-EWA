export class MemoryService
   {

    _lastId;
    _entities;
    get entities() {
        return this._entities;
    }


    constructor(initialId = 10000, sampleCreator = null) {
        this._lastId = initialId;
        this._entities = [];
        if (sampleCreator != null) {
            for (let i = 0; i < 7; i++) {
                this.save(sampleCreator(0));
            }
        }
    }

    currentAccount(){
        return this._entities[0];
    }

    searchUser(username){
        const foundEntity = this._entities.find(e => e?.userName == username);
        return Promise.resolve(foundEntity)
    }
    findAll() {
        return Promise.resolve(this._entities);
    }

    findById(id) {
        const foundEntity = this._entities.find(e => e?.id == id);
        return foundEntity;
    }

    save(entity) {
        if (entity == null) return;
        //console.log("Saving",entity);
        const index = this._entities.findIndex(e => e?.id == entity.id);
        if (index >= 0) {
            this._entities[index] = entity;
        } else {
            if (entity?.id == 0 || entity?.id == undefined) entity.id = ++this._lastId;
            this._entities.push(entity);
        }
        return entity;
    }

    deleteById(id) {
        this._entities = this._entities.filter(e => e?.id != id);
    }
}
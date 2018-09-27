
# Persistence Life Cycle

**Transient State : **   When you create a new object.(Entiity). When you change the data, and shut down the app,  you will not get it second time. 

**Persisit : ** save() or persist() :  Get into persistent state.  When you do anything in the object it is affected in database. Even if you modify after save()  it will modify the object. Because we have not removed the object from the persistent satte. 

**Detached state : ** To ditach the object from persistent state use  detach() or closse the session.

**Removed State : **  When you call remove() or delete() 

Note: When you call get()/ find() to retrive the object from database. It goes into persistent state again.

Transient -> Persisit -> Detached
	|			|
	V			V 
 Garbage  	 Removed



REF: https://www.youtube.com/watch?v=ZLeTFBvegfY&list=PLsyeobzWxl7qBZtsEvp_n2A7sJs2MpF3r&index=24

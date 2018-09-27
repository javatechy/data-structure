
# EAGER and LAzy Fetch:

Lazy waits and EAGER don't.

In Many to One if you are fetching the subclass values, then only hibenrate  will fire query onn database. for eg . student.getLaptops()

To avoid this use: @OneToMany(mappedBy="st", fetch= FetchType=EAGER)


# Caching:
Fisrt Level Cache:  Enabled by default. If you are getting same value 2 times from the database that will use first level cache/
IF u call same query 2 times in one session it will be called only once.

L2 cache: Need to enable by using ehcache or any other library. In this case you have more than one session. 
	Steps : add ehcache jar and hibernate-ehcahe intergrarion jar.
	Use @Cacheable on the entity on which you want to apply the cache.
	and need to give strategy as well. using @Cache(usage =CacheConcurrencyStrategy.READ_ONLY). Use READ_WRITE  if updating frequently
	For HQL use query.setCachable(true) 

# JAVA Stock market news feed filter.

A filter which gets a feed from the stock market and updates all of its users according
to their choices (their feed)


### Information:
The program is able to create new observers, each with their own filter and get news in real-time
and change data based on each users filter.


### Commands:
```

		create_obs obs_id filter <-> Creates a new user with the given id and filter
		delete_obs​ ​obs_id 		 <-> Deletes the given user
		feed​ ​name​ ​value			 <-> Notifies the observers that the stock called name has a new value
		print​ ​obs_id 			 <-> Prints the filtered content of obs_id.
	

```

### Printed cintent:
```
name - name of the stock

value - value of the stock

increase ​- fluctuation of aprice since the last printed value by the observer in percent.
													
num_of_changes ​- How many times there were feeds for this stock ( including those who did not pass the filter)


Also, in case an observer has more stocks to print, it will print them sorted alphabetically.

```




## Input example:


```

		begin
		create_obs 10 nil
		create_obs 11 ( eq name GOLD )
		create_obs 12 ( ( le value 4.8 ) || ( ge value 4.9 ) ) && ( eq name GOLD )
		feed GOLD 4.6
		feed GOLD 4.8
		print 11
		feed GOLD 4.7
		print 11
		print 10
		print 11
		feed GOLD 4.85
		print 12
		end

```


## Accepted input:

The input must start with the stirng "being" and end with the string "end"
the filter must have a white space between each operand/operator/paranthesis.

## Operators:

eq -> Equals ( works for both values and names )
ne -> Does not equal ( works for both values and names )
lt -> Lower than (values only)
le -> Lower or equal (values only)
gt -> Greater than (values only)
ge -> Greater or equal (values only)







def solution(cache_size, cities):
    answer = 0
    cache = []
    
    for i in range(len(cities)):
        cities[i] = cities[i].upper()
    
    while cities:
        city = cities.pop(0)
        # cache hit
        if city in cache:
            answer += 1
            # LRU algorithm
            cache.remove(city)
            cache.append(city)
        # cache miss
        else:
            answer += 5
            # set cache
            # cache is full
            if cache_size != 0 and len(cache) == cache_size:
                cache.pop(0)
                cache.append(city)
            elif len(cache) < cache_size:
                cache.append(city)
    
    return answer
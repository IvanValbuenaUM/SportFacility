package sportfacility.logic.suscriber;

import org.springframework.stereotype.Service;

@Service
public class EventManager {

	private Observer observer;

    public void subscribe(Observer o)
    {
        this.observer = o;
    }

    public void unsubscribe()
    {
    	this.observer = null;
    }

    public boolean update()
    {
        return observer.update();
    }
}

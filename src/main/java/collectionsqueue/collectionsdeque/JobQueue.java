package collectionsqueue.collectionsdeque;

import collectionsqueue.job.NoJobException;

import java.util.ArrayDeque;
import java.util.Deque;

public class JobQueue {
    public Job dispatchUrgentJob(Deque<Job> jobs) {
        jobTest(jobs);
        return jobs.pollFirst();
    }

    public Job dispatchNotUrgentJob(Deque<Job> jobs) {
        jobTest(jobs);
        return jobs.pollLast();
    }

    private void jobTest(Deque<Job> jobs) {
        if (jobs == null || jobs.isEmpty()) throw new NoJobException("No job available, get a rest!");
    }

    public Deque<Job> addJobByUrgency(Job... jobs) {
        Deque<Job> result = new ArrayDeque<>();
        for (Job one : jobs) {
            if (one.isUrgent()) {
                result.addFirst(one);
            } else {
                result.addLast(one);
            }
        }
        return result;
    }
}
//A Deque interfész egy kettős végű sor szerkezetet ír le, ennek az egyik implementációja az ArrayDeque kollekció.
//A feladatokat most kétféle minősítéssel látjuk el, fontos az, amelynek a prioritása kisebb, mint 5 a többi nem fontos.
//Fontos feladatok a sor elejére (head) addFirst() a nem fontosak a végére kerülnek addLast().
//A feltöltés a fentivel azonos módon működhet.
//
//Hibakezelés
//  Üres queue dobjon NoJobException kivételt.
//
//Megvalósítás
// publikus metódusok:
//  public Deque<Job> addJobByUrgency(Job... jobs)
//  public Job dispatchUrgentJob(Deque<Job> jobs) throws NoJobException
//  public Job dispatchNotUrgentJob(Deque<Job> jobs) throws NoJobException
//
//Az ArrayDeque implementáció rendelkezik getFirst() és getLast() metódusokkal
//
//Tippek
//  Hozzunk létre egy Job osztályt, a következők szerint: Legyen 3 final attribútuma:
//
//  int priority // 1 - 10 skálán osztályozzuk a prioritást
//  String jobDescription
//  boolean urgent // minden olyan job esetén true, ahol a prioritás < 5
//
//Legyen egy public Job(int priority, String jobDescription) konstruktora.
//Implementálja a Comparable interfészt, a kisebb számértékű prioritás van előbb a sorban.
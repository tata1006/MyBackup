package tata.mybackup.handler;

import tata.mybackup.Candidate;

/**
 * Created by Sonia on 2017/10/18.
 */

public interface Handler {
   byte[] Perform(Candidate candidate, byte[] target);
}

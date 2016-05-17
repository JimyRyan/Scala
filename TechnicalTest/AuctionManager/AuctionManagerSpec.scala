package com.guillaumemocquet

import org.scalatest._

class AuctionManagerSpec extends FlatSpec {

    "One winner buyer and price" must "be found" in {
        assertResult(Some("E", 130F)) {

            val am = new AuctionManager()

            am.offers(new Buyer("A"), Array(110F, 130F))
            // B : no bid
            am.offer(new Buyer("C"), 125F)
            am.offers(new Buyer("D"), Array(105F, 115F, 90F))
            am.offers(new Buyer("E"), Array(132F, 135F, 140F))

            am.getWinner(100F)
        }


        assertResult(Some("E", 130F)) {

            val am = new AuctionManager()

            am.offers(new Buyer("A"), Array(110F, 130F))
            // B : no bid
            am.offer(new Buyer("C"), 61F)
            am.offers(new Buyer("D"), Array(50F, 55F, 60F))
            am.offers(new Buyer("E"), Array(132F, 135F, 140F))
            am.offers(new Buyer("D"), Array(45F, 115F, 90F))
            am.offers(new Buyer("A"), Array(110F, 130F))
            am.offers(new Buyer("E"), Array(12F, 56F, 75F))
            am.offers(new Buyer("E"), Array(50F, 150F, 140F))

            am.getWinner(50F)
        }

        assertResult(Some("D", 150F)) {

            val am = new AuctionManager()

            am.offers(new Buyer("A"), Array(110F, 130F))
            // B : no bid
            am.offer(new Buyer("C"), 61F)
            am.offers(new Buyer("D"), Array(50F, 55F, 60F))
            am.offers(new Buyer("E"), Array(132F, 135F, 140F))
            am.offers(new Buyer("D"), Array(45F, 115F, 900F))
            am.offers(new Buyer("A"), Array(110F, 130F))
            am.offers(new Buyer("E"), Array(12F, 56F, 75F))
            am.offers(new Buyer("E"), Array(50F, 150F, 140F))

            am.getWinner(50F)
        }
    }

    "No winner" must "be found" in {
        assertResult(None) {

            val am = new AuctionManager()

            am.getWinner(0)
        }

        assertResult(None) {

            val am = new AuctionManager()

            am.getWinner(139F)
        }
        assertResult(None) {

            val am = new AuctionManager()

            am.offers(new Buyer("A"), Array(110F, 130F))
            // B : no bid
            am.offer(new Buyer("C"), 125F)
            am.offers(new Buyer("D"), Array(105F, 115F, 90F))
            am.offers(new Buyer("E"), Array(132F, 135F, 140F))

            am.getWinner(200F)
        }

        assertResult(None) {

            val am = new AuctionManager()

            am.offers(new Buyer("A"), Array(110F, 130F))
            // B : no bid
            am.offer(new Buyer("C"), 125F)
            am.offers(new Buyer("D"), Array(105F, 115F, 90F))
            am.offers(new Buyer("E"), Array(132F, 135F, 140F))

            am.getWinner(139F)
        }
    }
}